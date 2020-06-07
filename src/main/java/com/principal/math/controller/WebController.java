package com.principal.math.controller;

import com.principal.math.model.entity.Aluno;
import com.principal.math.model.entity.Professor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class WebController {
	
	public String index() {
		return "index";
	}

	@GetMapping("/login")
	public String login(@RequestParam String p){
			
			if(p.equals("aluno")){
				return "redirect:/aluno/login";
			}
			return "redirect:/professor/login";
	}
	
	@GetMapping("/cadastrar")
	public String cadastrar(@RequestParam String p, Model model){
			
			if(p.equals("aluno")){
				model.addAttribute("aluno", new Aluno());
				return "redirect:/aluno/cadastrar";
			}

			model.addAttribute("professor", new Professor());
			return "redirect:/professor/cadastrar";
	}
}
