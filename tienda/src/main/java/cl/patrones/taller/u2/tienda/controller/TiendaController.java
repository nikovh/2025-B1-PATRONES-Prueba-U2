package cl.patrones.taller.u2.tienda.controller;

import cl.patrones.taller.u2.bodegaje.domain.Producto;
import cl.patrones.taller.u2.bodegaje.service.BodegajeService;
import cl.patrones.taller.u2.catalogo.domain.Aviso;
import cl.patrones.taller.u2.catalogo.domain.Categoria;
import cl.patrones.taller.u2.catalogo.service.CategoriaService;
import cl.patrones.taller.u2.tienda.adapter.ProductoAvisoAdapter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TiendaController {

	private final BodegajeService bodegajeService;
	private final CategoriaService categoriaService;

	public TiendaController(BodegajeService bodegajeService, CategoriaService categoriaService) {
		this.bodegajeService = bodegajeService;
		this.categoriaService = categoriaService;
	}
	
	@GetMapping("/")
	public String inicio(Model model) {
		// TODO: Actividad 2: Avisos
		//model.addAttribute("avisos", avisos);
		List<Producto> productos = bodegajeService.getProductos();

		ProductoAvisoAdapter adapter = new ProductoAvisoAdapter(categoriaService, bodegajeService);
		List<Aviso> avisos = productos.stream()
			.map(adapter::adaptar)
			.collect(Collectors.toList());

		model.addAttribute("avisos", avisos);
		return "inicio";
	}
		
	@GetMapping("/categoria/{categoriaId}/{slug}")
	public String categoria(
			@PathVariable(name = "categoriaId") Long categoriaId,
			@PathVariable(name = "slug") String slug,
			Model model
	) {
		// TODO: Actividad 2: Avisos
		//model.addAttribute("avisos", avisos);
		//model.addAttribute("categoria", categoria);
		Categoria categoria = categoriaService.getCategoriaPorIdOrNull(categoriaId);
		List<Producto> productos = bodegajeService.getProductos();
		List<Producto> productosFiltrados = productos.stream()
			.filter(p -> p.getIdCategoria().equals(categoriaId))
			.collect(Collectors.toList());
		
		ProductoAvisoAdapter adapter = new ProductoAvisoAdapter(categoriaService, bodegajeService);
		List<Aviso> avisos = productosFiltrados.stream()
			.map(adapter::adaptar)
			.collect(Collectors.toList());

		model.addAttribute("avisos", avisos);
		model.addAttribute("categoria", categoria);
		return "categoria";
	}
	
	@GetMapping("/ingresar")
	public String login() {
		return "login";
	}
	
	@GetMapping("/ubicacion")
	public String ubicacion() {return "ubicacion";}
	
	@GetMapping("/contacto")
	public String contacto() {return "contacto";}
	
}
