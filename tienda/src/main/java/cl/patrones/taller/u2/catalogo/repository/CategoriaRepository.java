package cl.patrones.taller.u2.catalogo.repository;

import cl.patrones.taller.u2.catalogo.domain.Categoria;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.jpa.repository.EntityGraph;

import java.util.List;

public interface CategoriaRepository extends ListCrudRepository<Categoria, Long> {

    @EntityGraph(attributePaths = "subcategorias")
    List<Categoria> findByPadreIsNull();
}
