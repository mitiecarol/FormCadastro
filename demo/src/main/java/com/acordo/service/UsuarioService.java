package com.acordo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acordo.model.Form;
import com.acordo.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public List<Form> findAll() {
		return repository.findAll();
	}
	
	public Form findAll(Long id) {
		return repository.findAllById(id);
	}
	
	public Form save(Form usuario) {
		return repository.saveAndFlush(usuario);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}

