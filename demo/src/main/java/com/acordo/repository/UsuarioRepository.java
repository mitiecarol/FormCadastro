package com.acordo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acordo.model.Form;

public interface UsuarioRepository extends JpaRepository<Form, Long> {

	List<Form> findByCpf(String cpf);

	Form findAllById(Long id);

}
