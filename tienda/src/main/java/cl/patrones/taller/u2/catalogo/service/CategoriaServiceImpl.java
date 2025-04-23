package cl.patrones.taller.u2.catalogo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cl.patrones.taller.u2.catalogo.domain.Categoria;
import cl.patrones.taller.u2.catalogo.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	private final CategoriaRepository categoriaRepository;
	
	public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
		super();
		this.categoriaRepository = categoriaRepository;
	}
	
	@Override
	public List<Categoria> getCategorias() {
		//return categoriaRepository.findAll();
		return categoriaRepository.findByPadreIsNull();
	}

	@Override
	public Categoria getCategoriaPorIdOrNull(Long id) {
		return categoriaRepository.findById(id).orElse(null);
	}
}