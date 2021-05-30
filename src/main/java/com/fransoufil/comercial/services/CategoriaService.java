package com.fransoufil.comercial.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fransoufil.comercial.domain.Categoria;
import com.fransoufil.comercial.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria find(Integer id) {
		Categoria obj = categoriaRepository.findById(id).get();
		return obj;
	}

}
