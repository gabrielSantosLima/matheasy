package com.principal.math.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.servlet.ModelAndView;

import com.principal.math.controller.services.AlunoService;
import com.principal.math.controller.services.BlocoService;
import com.principal.math.model.entity.Aluno;
import com.principal.math.model.entity.BlocoDeNotas;

/**
 * BlocoController
 */
@Controller
@RequestMapping("aluno/{id}/blocos")
public class BlocoController {

	@Autowired
	private BlocoService service;

	@Autowired
	private AlunoService alunoService;

	private Optional<Aluno> getAlunoById(Integer id) {
		return alunoService.findById(id);
	}

	// List
	@GetMapping("/")
	public ModelAndView list(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("Calendario/index");
		Optional<Aluno> aluno = getAlunoById(id);

		if (!aluno.isPresent()) {
			return null;
		}

		List<BlocoDeNotas> blocos = service.findByAluno(aluno.get());
		modelAndView.addObject("blocos", blocos);

		return modelAndView;
	}

	// Create
	@PostMapping(path = "/", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public ResponseEntity<BlocoDeNotas> create(@RequestBody BlocoDeNotas blocoDeNotas,
			@PathVariable Integer id) {
		try {
			Optional<Aluno> aluno = getAlunoById(id);

			if (!aluno.isPresent()) {
				return null;
			}

			BlocoDeNotas createdBloco = service.save(blocoDeNotas, aluno.get());

			return ResponseEntity.ok(createdBloco);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	// Update
	@PutMapping(path = "/{idBlocoDeNotas}", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public ResponseEntity<BlocoDeNotas> update(@RequestBody BlocoDeNotas blocoDeNotas,
			@PathVariable("id") Integer id,
			@PathVariable("idBlocoDeNotas") Integer idBlocoDeNotas) {
		try {
			Optional<Aluno> aluno = getAlunoById(id);

			if (!aluno.isPresent()) {
				return ResponseEntity.badRequest().build();
			}

			Optional<BlocoDeNotas> bloco = service.findById(idBlocoDeNotas);

			if (id == bloco.get().getAluno().getId() || !bloco.isPresent()) {
				return ResponseEntity.badRequest().build();
			}

			BlocoDeNotas updatedBloco = service.update(idBlocoDeNotas, blocoDeNotas);

			return ResponseEntity.ok(updatedBloco);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}

	}

	// Delete
	@DeleteMapping("/{idBlocoDeNotas}")
	@ResponseBody
	public ResponseEntity<BlocoDeNotas> delete(@PathVariable("id") Integer id,
			@PathVariable("idBlocoDeNotas") Integer idBlocoDeNotas) {
		try {
			Optional<Aluno> aluno = getAlunoById(id);

			if (!aluno.isPresent()) {
				return ResponseEntity.badRequest().build();
			}

			Optional<BlocoDeNotas> bloco = service.findById(idBlocoDeNotas);

			if (id == bloco.get().getAluno().getId() || !bloco.isPresent()) {
				return ResponseEntity.badRequest().build();
			}
			
			service.delete(idBlocoDeNotas);
			
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}