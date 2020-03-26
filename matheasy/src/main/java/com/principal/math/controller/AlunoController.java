package com.principal.math.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.principal.math.controller.services.AlunoService;
import com.principal.math.model.entity.Aluno;

@Controller
@RequestMapping("/aluno/")
public class AlunoController {

	@Autowired
	private AlunoService service;

	@GetMapping("login")
	public String formLogar(Model model) {
		model.addAttribute("aluno", new Aluno());
		return "form-login";
	}

	@GetMapping("cadastrar")
	public String formCadastrar(Model model) {
		model.addAttribute("aluno", new Aluno());
		return "form-cadastro";
	}

	@PostMapping("/cadastrar/salvar")
	public String salvar(@Valid @ModelAttribute("aluno") Aluno aluno, BindingResult results, Model model) {

		if (results.hasErrors()) {
			return "/";
		}

		service.salvar(aluno);
		model.addAttribute(aluno);
		return "redirect:/";
	}

	@PostMapping("/login/entrar")
	public String entrar(@Valid @ModelAttribute("aluno") Aluno aluno, Model model) {
		if (service.verificarAtributosParaLogin(aluno)) {
			Iterable<Aluno> alunos = service.retornarLista();
			model.addAttribute("alunos", alunos);
			return "area-aluno";
		}

//		Aluno alunoLogado = service.retornaAluno(aluno);
		return "redirect:/";
	}
}
