package com.principal.math.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/aluno/homepage")
public class HomepageController {
	
	@GetMapping
	public String homepage(Model model, HttpSession session) {
		if(model.getAttribute("fragmento") == null) {
			model.addAttribute("fragmento", "fragments/modulos :: modulos");			
		}
		return "homepage";
	}
}
