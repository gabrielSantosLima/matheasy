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
import com.principal.math.utils.EntidadeLogin;

@Controller
@RequestMapping("/aluno/")
public class AlunoController {

	@Autowired
	private AlunoService service;

	@GetMapping("login")
	public String formLogar(Model model) {
		model.addAttribute("entidade", new EntidadeLogin());
		return "form-login";
	}

	@PostMapping("/login")
	public String entrar(@ModelAttribute("entidade") EntidadeLogin entidade, Model model) {
		boolean status = service.verificarAtributosParaLogin(entidade);
		
		if(status){
			return "/area-aluno";
		}
		
		System.out.println("Email: " + entidade.getEmail() + ", Senha: "+ entidade.getSenha());
		return "form-login";
	}
	
	@GetMapping("/login/area-aluno")
	public String entrarAreaLogado() {
		return "tela-logado";
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

}
