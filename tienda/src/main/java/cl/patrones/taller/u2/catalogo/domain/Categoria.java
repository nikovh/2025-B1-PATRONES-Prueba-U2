package cl.patrones.taller.u2.catalogo.domain;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Categoria {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;

	@ManyToOne
    @JoinColumn(name = "categoria_padre_id")
	private Categoria padre;

	@OneToMany(mappedBy = "padre", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Categoria> subcategorias = new ArrayList<>();
		

    public Categoria(String nombre, Categoria padre) {
        this.nombre = nombre;
        this.padre = padre;
    }

    public Categoria() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria getPadre() {
        return padre;
    }

    public void setPadre(Categoria padre) {
        this.padre = padre;
    }

    public List<Categoria> getSubcategorias() {
        return subcategorias;
    }

    public void setSubcategorias(List<Categoria> subcategorias) {
        this.subcategorias = subcategorias;
    }
		
}
