package cl.patrones.taller.u2.tienda.adapter;

import cl.patrones.taller.u2.bodegaje.domain.Producto;
import cl.patrones.taller.u2.catalogo.domain.Aviso;
import cl.patrones.taller.u2.catalogo.domain.Categoria;
import cl.patrones.taller.u2.catalogo.service.CategoriaService;
import cl.patrones.taller.u2.bodegaje.service.StockService;

public class ProductoAvisoAdapter {

    private final CategoriaService categoriaService;
    private final StockService stockService;

    public ProductoAvisoAdapter(CategoriaService categoriaService, StockService stockService) {
        this.categoriaService = categoriaService;
        this.stockService = stockService;
    }

    public Aviso adaptar(Producto producto) { 
        
        Categoria categoria = categoriaService.getCategoriaPorId(producto.getIdCategoria()):
        int stock = stockService.getStockTotalPorProducto(producto.getId());
        Long precio = Math.round(producto.getCosto() * 1.3);

        return new Aviso(
            producto.getId(),
            producto.getSku(),
            producto.getTitulo(),
            precio,
            producto.getImagen(),
            stock,
            categoria
        );
    }
}