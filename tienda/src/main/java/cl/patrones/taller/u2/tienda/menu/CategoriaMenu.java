package cl.patrones.taller.u2.tienda.menu;

import java.util.ArrayList;
import java.util.List;



public class CategoriaMenu implements ItemMenu {
    
    private final String texto;
    private final String enlace;
    private final String slug;
    // private final List<ItemMenu> subcategorias = new ArrayList<>();
    private final List<ItemMenu> hijos;

    public CategoriaMenu(String texto, String enlace) {
        this.texto = texto;
        this.enlace = enlace;
        this.slug = generarSlug(enlace);
        this.hijos = new ArrayList<>();
    }

    public void agregarSubcategoria(ItemMenu item) {
        hijos.add(item);
    }

    @Override
    public String getTexto() {
        return texto;
    }
    
    @Override
    public String getEnlace() {
        return enlace;
    }

    @Override
    public String getSlug() {
        return slug;
    }

    @Override
    public boolean tieneHijos() {
        return !hijos.isEmpty();
    }

    @Override
    public List<? extends ItemMenu> getHijos() {
        return hijos;
    }

    private String generarSlug(String enlace) {
        if (enlace == null || !enlace.contains("/")) return "";
        String[] partes = enlace.split("/");
        return partes[partes.length - 1];
    }
}