package com.principal.math.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.principal.math.controller.services.SecurityService;
import com.principal.math.controller.services.UsuarioService;
import com.principal.math.model.entity.Usuario;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@Autowired
	private SecurityService securityService;
	
	@GetMapping(path = "/perfil")
	public ModelAndView perfil() {
		ModelAndView mv = new ModelAndView("Perfil/index");
		
		try {
			Optional<Usuario> usuario = service.findByLoggedinUsername();
			
			mv.addObject("usuario", usuario.get());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mv;
	}

	@PostMapping(path = {"/perfil/{id}"})
	public String update(@ModelAttribute("usuario") Usuario usuario, @PathVariable Integer id) {
		try {
			
			service.update(id, usuario);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/perfil";
	}
	
	@GetMapping("/registration")
	public String registration(@RequestParam("u") String tipo, Model model) {
		
		model.addAttribute("usuario", new Usuario());
		
		if (tipo.equals("aluno")) {
			return "CadastroAluno/index";
		} else if (tipo.equals("professor")) {			
			return "CadastroProfessor/index";
		}else{
			return "LandingPage/index";
		}
		
	}
	
	@PostMapping("/registration")
	public String registration(@ModelAttribute("usuario") Usuario usuario, 
			String tipo, 
			Model model
		) {
		Optional<Usuario> existsUsuario = service.findByUsername(usuario.getUsername());
		
		if(existsUsuario.isPresent()) {
			model.addAttribute("error", "Nome de usuário já existe!");
			return "redirect:/registration:u="+tipo;
		}
		
		if(tipo == "aluno") {
			service.save(usuario, "ROLE_ALUNO");			
		}else {
			service.save(usuario, "ROLE_PROFESSOR");						
		}
		
		securityService.autoLogin(usuario.getUsername(), usuario.getPassword());
		
		return "LandingPage/index";
	}
	
	@GetMapping("/login")
	private String login(Model model, String error, String logout) {
		
		if (error != null) {
			System.out.println(error);
			model.addAttribute("error", "Usuário ou senha inválidos!");
		}
		if (logout != null) {
			model.addAttribute("message", "Você foi deslogado corretamente!");
			return "LandingPage/index";
		}
		
		return "Login/index";
	}
	
	@GetMapping("/home")
	private String home() {
		return "Homepage/index";
	}
}