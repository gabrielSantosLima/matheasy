package com.principal.math.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.principal.math.controller.services.AlunoService;
import com.principal.math.model.entity.Aluno;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

	AlunoService service;
	
	@PostMapping("/salvar")
	public String salvar(Aluno aluno) {
		return "redirect:/";
	}

	@GetMapping("/retornar-alunos")
	public String entrar(Aluno aluno) {
		if(service.verificaAluno(aluno)) {
			return "tela-logado";			
		}else {
			return "tela-erro";
		}
	}

	@DeleteMapping("/deletar/{id}")
	public String deletar(@PathVariable("id") Integer id) {
		
		return "redirect:/";
	}
}
