package cl.patrones.taller.u2.tienda.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import cl.patrones.taller.u2.catalogo.domain.Categoria;
import cl.patrones.taller.u2.catalogo.service.CategoriaService;
import cl.patrones.taller.u2.tienda.menu.CategoriaMenu;
import cl.patrones.taller.u2.tienda.menu.EnlaceItemMenu;
import cl.patrones.taller.u2.tienda.menu.ItemMenu;
import cl.patrones.taller.u2.tienda.menu.util.Slugger;

@ControllerAdvice
public class MenuControllerAdvice {

	private final CategoriaService categoriaService;

	public MenuControllerAdvice(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

	@ModelAttribute("menu")
	public List<ItemMenu> menu() {
		// TODO: Actividad 1
		List<ItemMenu> menu = new ArrayList<>();
		menu.add(new EnlaceItemMenu("Inicio", "/"));
		
		CategoriaMenu menuCategorias = new CategoriaMenu("Categorias", "/categoria");
		List<Categoria> categorias = categoriaService.getCategorias();
		if (categorias != null && !categorias.isEmpty()) {
			for (Categoria cate : categorias) {
				menuCategorias.agregarSubcategoria(construirDesdeCategoria(cate));
			}
		}
		menu.add(menuCategorias);

		menu.add(new EnlaceItemMenu("Ubicacion", "/ubicacion"));
		menu.add(new EnlaceItemMenu("Contacto", "/contacto"));
		return menu;
	}

	private CategoriaMenu construirDesdeCategoria(Categoria categoria) {
		String slug = Slugger.toSlug(categoria.getNombre());
		String enlace = "/categoria/" + categoria.getId() + "/" + slug;
		
		CategoriaMenu cateMenu = new CategoriaMenu(categoria.getNombre(), enlace);

		if (categoria.getSubcategorias() != null && !categoria.getSubcategorias().isEmpty()) {
			for (Categoria subcate : categoria.getSubcategorias()) {
				cateMenu.agregarSubcategoria(construirDesdeCategoria(subcate));
			}
		}
		return cateMenu; 
    }
}