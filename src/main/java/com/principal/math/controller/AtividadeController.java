package com.principal.math.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.principal.math.controller.services.AtividadeService;
import com.principal.math.controller.services.ModuloService;
import com.principal.math.model.entity.Atividade;
import com.principal.math.model.entity.Modulo;

@RestController
@CrossOrigin
@RequestMapping(path = "/atividades/{id}")
public class AtividadeController {

	@Autowired
	private AtividadeService service;

	@Autowired
	private ModuloService moduloService;

	public Optional<Modulo> getModuloById(Integer id) {
		return moduloService.findById(id);
	}
	
	@GetMapping(path="/view")
	public ModelAndView view(@PathVariable Integer id) {
		ModelAndView mv = new ModelAndView("Quiz/index");
		
		mv.addObject("id", id.intValue());
		
		return mv;
	}
	
	@GetMapping(path = { "/", "" }, produces= MediaType.APPLICATION_JSON_VALUE)
	public List<Atividade> list(@PathVariable Integer id) {
		Optional<Modulo> modulo = getModuloById(id);

		if (!modulo.isPresent()) {
			return new ArrayList<>();
		}

		List<Atividade> atividades = service.findByModulo(modulo.get());
		
		atividades.stream().forEach(atividade -> atividade.setModulo(null));
		
		return atividades;
	}
}