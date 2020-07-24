package com.principal.math.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.principal.math.controller.services.AlunoService;
import com.principal.math.controller.services.EventoService;
import com.principal.math.model.entity.Aluno;
import com.principal.math.model.entity.Evento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	private Optional<Aluno> getAlunoById(Integer id) {
		return alunoService.findById(id);
	}

	// List
	@GetMapping(path = { "/", "" }, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Evento> list(@PathVariable Integer id) {
		Optional<Aluno> aluno = getAlunoById(id);
		
		if(!aluno.isPresent()) {
			return new ArrayList<>();
		}
		
		List<Evento> eventos = service.findByAluno(aluno.get());
		
		return eventos;
	}

	// Create
	@PostMapping(path = { "/",
			"" }, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Evento> create(@PathVariable Integer id,
			@RequestBody Evento evento) {
		try {
			Optional<Aluno> aluno = getAlunoById(id);

			if(!aluno.isPresent()) {
				return ResponseEntity.badRequest().build();				
			}
			
			Evento createdEvento = service.save(evento, aluno.get());

			return ResponseEntity.ok(createdEvento);
		} catch (Exception e) {

			return ResponseEntity.badRequest().build();
		}
	}

	// Update
	@PutMapping(path = "/{idEvento}", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public ResponseEntity<Evento> update(@RequestBody Evento evento,
			@PathVariable("id") Integer id, @PathVariable("idEvento") Integer idEvento) {

		try {

			if (id != evento.getAluno().getId()) {
				return ResponseEntity.badRequest().build();
			}

			Evento updatedEvento = service.update(idEvento, evento);

			return ResponseEntity.ok(updatedEvento);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	// Delete
	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Evento> delete(@PathVariable("id") Integer id,
			@PathVariable("idEvento") Integer idEvento) {
		try {
			Optional<Evento> evento = service.findById(idEvento);

			if (!evento.isPresent()) {
				return ResponseEntity.badRequest().build();
			}

			if (id != evento.get().getAluno().getId()) {
				return ResponseEntity.badRequest().build();
			}

			service.delete(idEvento);

			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}