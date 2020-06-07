package com.principal.math.controller;

import javax.servlet.http.HttpSession;
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
@RequestMapping("/aluno")
public class AlunoController {
	
	@Autowired
	private AlunoService service;
	
	@GetMapping("/login")
	public String setEntity(Model model) {
		model.addAttribute("entidade", new EntidadeLogin());
		
		return "login";
	}
	
	@GetMapping("/cadastrar")
	public String setAluno(Model model) {
		model.addAttribute("aluno", new Aluno());
		
		return "cadastrar";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("entidade") EntidadeLogin entidade, HttpSession session) {
		
		boolean status = service.login(entidade);
		
		if (status) {
			
			Aluno aluno = service.getAlunoByEmailAndSenha(entidade.getEmail(), entidade.getSenha());
			session.setAttribute("aluno", aluno);
			
			return "redirect:/aluno/homepage";
		}
		return "redirect:/aluno/login";
	}
	
	@PostMapping("/cadastrar")
	public String salvar(@Valid @ModelAttribute("aluno") Aluno aluno, BindingResult results, Model model) {
		
		if (results.hasErrors()) {
			return "/";
		}
		
		service.salvar(aluno);
		model.addAttribute(aluno);
		
		return "redirect:/";
	}
}
