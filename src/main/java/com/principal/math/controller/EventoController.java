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
@RequestMapping("/eventos")
public class EventoController {

	@Autowired
	private EventoService service;

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/view")
	public ModelAndView view(HttpSession session) {
		try {	
			ModelAndView md = new ModelAndView("Calendario/index");
			Optional<Usuario> usuario = usuarioService.findByLoggedinUsername();
			
			if(!usuario.isPresent()) {
				return md;
			}
			
			md.addObject("usuario", usuario.get());
			
			return md;
		}catch(Exception e) {
			e.printStackTrace();
			
			return new ModelAndView();
		}
	}
	
	// List
	@GetMapping(path = { "/", "" })
	@ResponseBody
	public List<Evento> list(@PathVariable Integer id) {
		try {			
			Optional<Usuario> usuario = usuarioService.findByLoggedinUsername();
			
			if(!usuario.isPresent()) {
				return new ArrayList<>();
			}
			
			List<Evento> eventos = service.findByAluno(usuario.get());
			
			return eventos;
		}catch(Exception e) {
			e.printStackTrace();
			
			return new ArrayList<>();
		}
	}

	// Create
	@PostMapping(path = { "/","" }, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Evento> create(@PathVariable Integer id,
			@RequestBody Evento evento) {
		try {
			Optional<Usuario> usuario = usuarioService.findByLoggedinUsername();

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
	@PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public ResponseEntity<Evento> update(@RequestBody Evento evento,
			@PathVariable("id") Integer id) {

		try {
			Optional<Usuario> usuario = usuarioService.findByLoggedinUsername();

			if (usuario.get().getId() != evento.getUsuario().getId()) {
				return ResponseEntity.badRequest().build();
			}

			Evento updatedEvento = service.update(id, evento);

			return ResponseEntity.ok(updatedEvento);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	// Delete
	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Evento> delete(@PathVariable("id") Integer id) {
		try {
			Optional<Usuario> usuario = usuarioService.findByLoggedinUsername();
			Optional<Evento> evento = service.findById(id);

			if (!evento.isPresent()) {
				return ResponseEntity.badRequest().build();
			}

			if (usuario.get().getId() != evento.get().getUsuario().getId()) {
				return ResponseEntity.badRequest().build();
			}

			service.delete(id);

			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}