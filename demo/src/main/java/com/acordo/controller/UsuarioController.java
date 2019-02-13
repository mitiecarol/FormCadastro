package com.acordo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.acordo.model.Form;
import com.acordo.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@GetMapping("/")
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("/user");
		mv.addObject("posts", service.findAll());

		return mv;
	}

	@GetMapping("/add")
	public ModelAndView add(Form usuario) {

		ModelAndView mv = new ModelAndView("/usuarioAdd");
		mv.addObject("post", usuario);

		return mv;
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {

		return add(service.findAll(id));
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {

		service.delete(id);

		return findAll();
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid Form usuario, BindingResult result) {

		if (result.hasErrors()) {
			return add(usuario);
		}

		service.save(usuario);

		return findAll();
	}

}
