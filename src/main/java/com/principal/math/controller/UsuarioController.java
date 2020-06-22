package com.principal.math.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.principal.math.controller.services.AlunoService;
import com.principal.math.controller.services.ProfessorService;
import com.principal.math.controller.services.SecurityService;
import com.principal.math.model.entity.Aluno;
import com.principal.math.model.entity.Professor;
import com.principal.math.model.entity.Usuario;

@Controller
public class UsuarioController {
	
	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private ProfessorService professorService;

	@Autowired
	private SecurityService securityService;
	
	@GetMapping("/registration")
	private String registration(@RequestParam("p") String tipo, Model model) {
		
		if(tipo.equals("aluno")) {
			
			model.addAttribute("usuario", new Aluno());
		
		}else if(tipo.equals("professor")) {
			
			model.addAttribute("usuario", new Professor());			
		
		}
		
		return "cadastrar";
	}

	@PostMapping("/registration")
	private String registration(@ModelAttribute("usuario") Usuario usuario, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "cadastrar";
		}
		
		if(usuario instanceof Aluno) {
			alunoService.salvar((Aluno) usuario);
		}else {
			professorService.salvar((Professor) usuario);
		}
		
		securityService.autoLogin(usuario.getUsername(), usuario.getPasswordConfirm());
		
		return "redirect:/home";
	}
	
	@GetMapping("/login")
	private String login(Model model, String error, String logout) {
		
		if(error != null) {
			model.addAttribute("error", "Usuário ou senha inválidos!");
		}
		if(logout != null) {
			model.addAttribute("message", "Você foi logado corretamente!");			
		}
		
		return "login";
	}
	
	@GetMapping("/home")
	private String home() {
		return "homepage";
	}
}
