package com.principal.math.controller;


import java.util.List;

import com.principal.math.controller.services.AlunoService;
import com.principal.math.controller.services.EventoService;
import com.principal.math.model.entity.Aluno;
import com.principal.math.model.entity.Evento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * BlocoController
 */
@Controller
@RequestMapping("aluno/{id}/eventos")
public class EventoController {

	@Autowired
	private EventoService service;
	
	@Autowired
	private AlunoService alunoService;

	@GetMapping("/")
	@ResponseBody
	private List<Evento> all(@PathVariable Integer id) {
		Aluno aluno = alunoService.getEntityById(id).get();
		List<Evento> eventos = service.findByAluno(aluno);
		
		return eventos;
	}
	
	@PostMapping("/")
	private Evento create(@PathVariable Integer id, Evento evento) {
		Aluno aluno = alunoService.getEntityById(id).get();
		evento.setAluno(aluno);
		
		Evento eventocadastrado = service.salvar(evento);
		
		return eventocadastrado;
	}
	
	@PutMapping("/{idEvento}")
	private List<Evento> update(@PathVariable("id") Integer id,
			@PathVariable("idEvento") Integer idEvento, Evento eventoNovo) {
		Aluno aluno = alunoService.getEntityById(id).get();
		List<Evento> eventos = service.findByAluno(aluno);
		
		return eventos;
	}
	
	@DeleteMapping("/{idEvento}")
	private List<Evento> delete(@PathVariable("id") Integer id, 
			@PathVariable("idEvento") Integer idEvento) {
		Aluno aluno = alunoService.getEntityById(id).get();
		List<Evento> eventos = service.findByAluno(aluno);
		
		return eventos;
	}

}