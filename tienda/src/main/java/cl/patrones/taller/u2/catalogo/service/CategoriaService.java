package cl.patrones.taller.u2.catalogo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cl.patrones.taller.u2.catalogo.domain.Categoria;
import cl.patrones.taller.u2.catalogo.repository.CategoriaRepository;

@Service
public class CategoriaService {

	private final CategoriaRepository categoriaRepository;

	public CategoriaService(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	public List<Categoria> getCategorias() {
        return categoriaRepository.findByPadreIsNull();
	};

	public Optional<Categoria> getCategoriaPorId(Long id) {
        return categoriaRepository.findById(id);
    }

	public Categoria getCategoriaPorIdOrNull(Long id) {
		return CategoriaRepository.findById(id).orElse(null);
	}
}
