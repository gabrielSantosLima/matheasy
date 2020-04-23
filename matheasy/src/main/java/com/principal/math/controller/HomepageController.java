package com.principal.math.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/aluno/homepage")
public class HomepageController {
	
	// @GetMapping("/{frag}")
	// public String homepage(@PathVariable("frag") String frag, HttpSession session) {
	@GetMapping
	public String homepage(Model model, HttpSession session) {
		model.addAttribute("template", "modulos");
		
		return "homepage";
	}
}
