package com.fransoufil.comercial.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fransoufil.comercial.domain.Categoria;
import com.fransoufil.comercial.repositories.CategoriaRepository;
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

}
