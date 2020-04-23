package com.principal.math.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.principal.math.controller.services.ModuloService;
import com.principal.math.model.entity.Modulo;

@Controller
@RequestMapping("/aluno/homepage/modulo")
public class ModuloController {

	@Autowired
	private ModuloService service;

	@GetMapping("/{ano}")
	public ModelAndView getModulos(@PathVariable("ano") Integer ano) {
		ModelAndView mv = new ModelAndView("testeModulo");
		List<Modulo> modulos = service.findByAno(ano);

		if (modulos.isEmpty()) {
			mv.addObject("menssagem", "Nenhum módulo cadastrado!");
			return mv;
		}

		mv.addObject("modulos", modulos);
		return mv;
	}

	@GetMapping("/{ano}/{nome}")
	public ModelAndView getModulo(@PathVariable("nome") String nomeModulo, @PathVariable("ano") Integer ano) {
		ModelAndView mv = new ModelAndView("testeModulo");
		Optional<Modulo> modulo = service.findByTituloAndAno(nomeModulo, ano);

		if (modulo.isPresent()) {
			mv.addObject("modulo", modulo.get());
			System.out.println(modulo);
			return mv;
		}

		mv.addObject("menssagem", "Modulo não existe");
		return mv;

	}
}
