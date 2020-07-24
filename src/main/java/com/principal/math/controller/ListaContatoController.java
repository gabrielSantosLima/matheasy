package com.principal.math.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.principal.math.controller.services.AlunoService;
import com.principal.math.controller.services.ListaContatoService;
import com.principal.math.controller.services.ProfessorService;
import com.principal.math.model.entity.Aluno;
import com.principal.math.model.entity.ListaContato;
import com.principal.math.model.entity.Professor;

@Controller
@RequestMapping("/lista-contato")
public class ListaContatoController {

	@Autowired
	private ListaContatoService service;

	@Autowired
	private ProfessorService professorService;

	@Autowired
	private AlunoService alunoService;

	@GetMapping(path = {"/{id}", ""},  produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ListaContato> list(@PathVariable Integer id,@RequestParam String tipo){
		
		if(tipo.equals("professor")) {
		
			Optional<Professor> professor = professorService.findById(id);
		
			if(!professor.isPresent()) {
				return new ArrayList<>();
			}
			
			return service.findByProfessor(professor.get());
		}else if(tipo.equals("aluno")){
			
			Optional<Aluno> aluno = alunoService.findById(id);
			
			if(!aluno.isPresent()) {
				return new ArrayList<>();
			}
			
			return service.findByAluno(aluno.get());
		}
		
		return new ArrayList<>();
	}
	
	@PostMapping(path = "/{idAluno}/{idProfessor}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ListaContato> create(@PathVariable("idAluno") Integer idAluno,
			@PathVariable("idProfessor") Integer idProfessor) {
		try {
			Optional<Aluno> aluno = alunoService.findById(idAluno);
			Optional<Professor> professor = professorService.findById(idProfessor);

			if (!aluno.isPresent() || !professor.isPresent()) {
				return ResponseEntity.badRequest().build();
			}

			ListaContato createdListaContato = service.save(aluno.get(), professor.get());

			return ResponseEntity.ok(createdListaContato);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@DeleteMapping(path = "/{idAluno}/{idProfessor}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ListaContato> delete(@PathVariable("idAluno") Integer idAluno,
			@PathVariable("idProfessor") Integer idProfessor
			){
		try {
			Optional<Aluno> aluno = alunoService.findById(idAluno);
			Optional<Professor> professor = professorService.findById(idProfessor);
			
			if (!aluno.isPresent() || !professor.isPresent()) {
				return ResponseEntity.badRequest().build();
			}

			service.delete(aluno.get(), professor.get());

			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
