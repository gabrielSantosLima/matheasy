package com.principal.math.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.principal.math.controller.services.UsuarioService;
import com.principal.math.model.entity.Usuario;

@Controller
@RequestMapping("/ranking")
public class RankingController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping(path = {"/", ""})
	public ModelAndView ranking(String role) {
		ModelAndView mv = new ModelAndView("Ranking/index");
		
		try {
			List<Usuario> ranking;
			
			if(role != null) {
				ranking = service.findTop10ByRoleOrderByPontuacaoDesc(role);				
			}else {
				ranking = service.findTop10ByOrderByPontuacaoDesc();								
			}
			
			mv.addObject("ranking", ranking);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return mv;
	}
}
