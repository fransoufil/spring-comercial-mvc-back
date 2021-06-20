package com.fransoufil.comercial.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fransoufil.comercial.domain.Cliente;
import com.fransoufil.comercial.repositories.ClienteRepository;
import com.fransoufil.comercial.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository ClienteRepository;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = ClienteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

}
