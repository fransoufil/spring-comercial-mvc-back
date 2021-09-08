package com.fransoufil.comercial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fransoufil.comercial.domain.Categoria;
import com.fransoufil.comercial.repositories.CategoriaRepository;
import com.fransoufil.comercial.services.exceptions.DataIntegrityException;
import com.fransoufil.comercial.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return categoriaRepository.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return categoriaRepository.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
		categoriaRepository.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Nao e possivel excluir uma categoria que possui produtos");
		}
	}

	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}
}
