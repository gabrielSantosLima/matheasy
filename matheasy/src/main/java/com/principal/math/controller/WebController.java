package com.principal.math.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WebController {
	
	public String index() {
		return "index";
	}

	@GetMapping("/arealogado")
	public String areaLogado(Model model){
		return "tela-logado";
	}
}
