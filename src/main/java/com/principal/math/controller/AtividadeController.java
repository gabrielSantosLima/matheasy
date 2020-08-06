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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.principal.math.controller.services.AtividadeService;
import com.principal.math.controller.services.ModuloService;
import com.principal.math.model.entity.Atividade;
import com.principal.math.model.entity.Modulo;

@Controller
@RequestMapping(path = "/modulos/{id}/atividades")
public class AtividadeController {

	@Autowired
	private AtividadeService service;

	@Autowired
	private ModuloService moduloService;

	public Optional<Modulo> getModuloById(Integer id) {
		return moduloService.findById(id);
	}

	@GetMapping(path = { "/", "" }, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Atividade> list(@PathVariable Integer id) {
		Optional<Modulo> modulo = getModuloById(id);

		if (!modulo.isPresent()) {
			return new ArrayList<>();
		}

		List<Atividade> atividades = service.findByModulo(modulo.get());

		return atividades;
	}

	@PostMapping(path = { "/", "" }, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Atividade> create(@PathVariable Integer id,
			@RequestBody Atividade atividade) {
		try {
			Optional<Modulo> modulo = getModuloById(id);

			if (!modulo.isPresent()) {
				return ResponseEntity.badRequest().build();
			}
			
			Atividade createdAtividade = service.save(atividade, modulo.get());
			
			return ResponseEntity.ok(createdAtividade);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@DeleteMapping(path = "/{idModulo}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Atividade> delete(@PathVariable("id") Integer id,
			@PathVariable("idAtividade") Integer idAtividade) {
		try {
			Optional<Atividade> atividade = service.findById(idAtividade);
			
			if (id == atividade.get().getModulo().getId() || !atividade.isPresent()) {
				return ResponseEntity.badRequest().build();
			}
			
			service.delete(idAtividade);
			
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
