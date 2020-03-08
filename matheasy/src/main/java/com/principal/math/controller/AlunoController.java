package com.principal.math.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.principal.math.controller.services.AlunoService;
import com.principal.math.model.entity.Aluno;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

	AlunoService service;

	@GetMapping("/")
	public ModelAndView redireciona() {
		return new ModelAndView("form-cadastro");
	}
	
	@PostMapping("/salvar")
	public String salvar(Model model, Aluno aluno) {

		service.salvar(aluno);
		model.addAttribute(aluno);

		return "redirect:/";
	}

	@GetMapping("/login")
	public String entrar(Model model, Aluno aluno) {

		if (service.verificaEntidade(aluno.getId())) {
			model.addAllAttributes(service.retornarLista());

			return "tela-logado";
		} else {
			return "tela-erro";
		}
	}

	@DeleteMapping("/deletar/{id}")
	public String deletar(@PathVariable("id") Integer id) {

		if (service.existePorId(id)) {
			service.deletar(id);

			return "redirect:/";
		} else {
			return "redirect:/aluno/deletar";
		}
	}
}
