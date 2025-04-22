package cl.patrones.taller.u2.tienda.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;



public class EnlaceItemMenu implements ItemMenu {
    
    private final String texto;
    private final String enlace;
    private final String slug;

    public EnlaceItemMenu(String texto, String enlace) {
        this.texto = texto;
        this.enlace = enlace;
        this.slug = generarSlug(enlace);
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
        return false;
    }

    @Override
    public List<? extends ItemMenu> getHijos() {
        return Collections.emptyList();
    }

    private String generarSlug(String enlace) {
        if (enlace == null || enlace.isBlank() || !enlace.contains("/")) return "";
        String[] partes = enlace.split("/");
        return partes.length > 0 ? partes[partes.length - 1] : "";
    }
}

