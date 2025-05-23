/*
package cl.patrones.taller.u2.tienda.adapter;

import cl.patrones.taller.u2.bodegaje.domain.Producto;
import cl.patrones.taller.u2.catalogo.domain.Aviso;
import cl.patrones.taller.u2.catalogo.domain.Categoria;
import cl.patrones.taller.u2.catalogo.service.CategoriaService;
import cl.patrones.taller.u2.bodegaje.service.BodegajeService;

public class ProductoAvisoAdapter {

    private final CategoriaService categoriaService;
    private final BodegajeService bodegajeService;

    public ProductoAvisoAdapter(CategoriaService categoriaService, BodegajeService bodegajeService) {
        this.categoriaService = categoriaService;
        this.bodegajeService = bodegajeService;
    }

    public Aviso adaptar(Producto producto) { 
        
        Categoria categoria = null;
        if (producto.getIdCategoria() != null) {
            categoria = categoriaService.getCategoriaPorIdOrNull(producto.getIdCategoria());
        }
        int stock = bodegajeService.getStockTotalPorProducto(producto.getId());
        Long precio = Math.round(producto.getCosto() * 1.3);

        return new Aviso(
            producto.getId(),
            producto.getSku(),
            producto.getNombre(),
            precio,
            producto.getImagen(),
            stock,
            categoria
        );
    }
}
*/

package cl.patrones.taller.u2.tienda.adapter;

import cl.patrones.taller.u2.bodegaje.domain.Producto;
import cl.patrones.taller.u2.bodegaje.service.BodegajeService;
import cl.patrones.taller.u2.catalogo.domain.Aviso;
import cl.patrones.taller.u2.catalogo.domain.Categoria;
import cl.patrones.taller.u2.catalogo.domain.Clasificacion;
import cl.patrones.taller.u2.catalogo.repository.ClasificacionRepository;
import cl.patrones.taller.u2.catalogo.service.CategoriaService;

public class ProductoAvisoAdapter {

    private final CategoriaService categoriaService;
    private final BodegajeService bodegajeService;
    private final ClasificacionRepository clasificacionRepository;

    public ProductoAvisoAdapter(CategoriaService categoriaService,
                                 BodegajeService bodegajeService,
                                 ClasificacionRepository clasificacionRepository) {
        this.categoriaService = categoriaService;
        this.bodegajeService = bodegajeService;
        this.clasificacionRepository = clasificacionRepository;
    }

    public Aviso adaptar(Producto producto) { 
        
        Categoria categoria = clasificacionRepository.findFirstBySku(producto.getSku())
                .map(Clasificacion::getCategoria)
                .orElse(null);
        int stock = bodegajeService.getStockTotalPorProducto(producto.getId());
        Long precio = Math.round(producto.getCosto() * 1.3);

        return new Aviso(
            producto.getId(),
            producto.getSku(),
            producto.getNombre(),
            precio,
            producto.getImagen(),
            stock,
            categoria
        );
    }
}