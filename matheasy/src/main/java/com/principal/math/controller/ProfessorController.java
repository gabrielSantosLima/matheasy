package com.principal.math.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.principal.math.controller.services.ProfessorService;
import com.principal.math.model.entity.Professor;

@Controller
@RequestMapping("/professor")
public class ProfessorController {

	ProfessorService service;

	@PostMapping("/salvar")
	public String salvar(Model model, Professor professor) {

		service.salvar(professor);
		model.addAttribute(professor);

		return "redirect:/";
	}

	@GetMapping("/login")
	public String entrar(Model model, Professor professor) {

		if (service.existsById(professor.getId())) {
			model.addAllAttributes(service.listar());

			return "tela-logado";
		} else {
			return "tela-erro";
		}
	}

	@DeleteMapping("/deletar/{id}")
	public void deletar(@PathVariable("id") Integer id) {
		if (service.existsById(id)) {
			service.deletar(id);
		}
	}
}
