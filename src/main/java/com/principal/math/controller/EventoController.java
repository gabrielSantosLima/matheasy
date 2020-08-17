package com.principal.math.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import com.principal.math.controller.services.EventoService;
import com.principal.math.controller.services.UsuarioService;
import com.principal.math.model.entity.Evento;
import com.principal.math.model.entity.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * BlocoController
 */
@Controller
@CrossOrigin
@RequestMapping("aluno/{id}/eventos")
public class EventoController {

	@Autowired
	private EventoService service;

	@Autowired
	private UsuarioService usuarioService;

	private Optional<Usuario> getUsuarioById(Integer id) {
		return usuarioService.findById(id);
	}

	@GetMapping("/view")
	public ModelAndView view(HttpSession session) {
		ModelAndView md = new ModelAndView("Calendario/index");
		Integer id = (Integer) session.getAttribute("JSESSIONID");
		Optional<Usuario> usuario = getUsuarioById(id);
		
		if(!usuario.isPresent()) {
			return md;
		}
		
		md.addObject("usuario", usuario.get());
		return md;
	}
	
	// List
	@GetMapping(path = { "/", "" })
	@ResponseBody
	public List<Evento> list(@PathVariable Integer id) {
		Optional<Usuario> usuario = getUsuarioById(id);
		
		if(!usuario.isPresent()) {
			return new ArrayList<>();
		}
		
		List<Evento> eventos = service.findByAluno(usuario.get());
		
		return eventos;
	}

	// Create
	@PostMapping(path = { "/","" }, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Evento> create(@PathVariable Integer id,
			@RequestBody Evento evento) {
		try {
			Optional<Usuario> usuario = getUsuarioById(id);

			if(!usuario.isPresent()) {
				return ResponseEntity.badRequest().build();				
			}
			
			Evento createdEvento = service.save(evento, usuario.get());

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

			if (id != evento.getUsuario().getId()) {
				return ResponseEntity.badRequest().build();
			}

			Evento updatedEvento = service.update(idEvento, evento);

			return ResponseEntity.ok(updatedEvento);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	// Delete
	@DeleteMapping("/{idEvento}")
	@ResponseBody
	public ResponseEntity<Evento> delete(@PathVariable("id") Integer id,
			@PathVariable("idEvento") Integer idEvento) {
		try {
			Optional<Evento> evento = service.findById(idEvento);

			if (!evento.isPresent()) {
				return ResponseEntity.badRequest().build();
			}

			if (id != evento.get().getUsuario().getId()) {
				return ResponseEntity.badRequest().build();
			}

			service.delete(idEvento);

			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}