package com.principal.math.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.principal.math.controller.services.BlocoService;
import com.principal.math.controller.services.UsuarioService;
import com.principal.math.model.entity.BlocoDeNotas;
import com.principal.math.model.entity.Usuario;

/**
 * BlocoController
 */
@Controller
@RequestMapping("usuario/{id}/blocos")
public class BlocoController {

	@Autowired
	private BlocoService service;

	@Autowired
	private UsuarioService usuarioService;

	private Optional<Usuario> getUsuarioById(Integer id) {
		return usuarioService.findById(id);
	}

	@GetMapping("/view")
	public ModelAndView view(@PathVariable Integer id) {
		ModelAndView mv = new ModelAndView("Card/index");
		Usuario usuario = usuarioService.findById(id).get();
		
		List<BlocoDeNotas> blocos = service.findByUsuario(usuario);
		
		mv.addObject("card", new BlocoDeNotas());
		mv.addObject("cards", blocos);

		return mv;
	}

	// List
	@GetMapping("/")
	public List<BlocoDeNotas> list(@PathVariable Integer id) {
		Optional<Usuario> usuario = getUsuarioById(id);

		if (!usuario.isPresent()) {
			return new ArrayList<>();
		}

		List<BlocoDeNotas> blocos = service.findByUsuario(usuario.get());
		return blocos;
	}

	// Create
	@PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String create(@RequestBody BlocoDeNotas blocoDeNotas,
			@PathVariable Integer id) {
		try {
			Optional<Usuario> usuario = getUsuarioById(id);

			if (!usuario.isPresent()) {
				return "/view";
			}

			BlocoDeNotas createdBloco = service.save(blocoDeNotas, usuario.get());

			return "/view";
		} catch (Exception e) {
			return "/view";
		}
	}

	// Update
	@PutMapping(path = "/{idBlocoDeNotas}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String update(@RequestBody BlocoDeNotas blocoDeNotas,
			@PathVariable("id") Integer id,
			@PathVariable("idBlocoDeNotas") Integer idBlocoDeNotas) {
		try {
			Optional<Usuario> usuario = getUsuarioById(id);

			if (!usuario.isPresent()) {
				return "/view";
			}

			Optional<BlocoDeNotas> bloco = service.findById(idBlocoDeNotas);

			if (id == bloco.get().getUsuario().getId() || !bloco.isPresent()) {
				return "/view";
			}

			BlocoDeNotas updatedBloco = service.update(idBlocoDeNotas, blocoDeNotas);

			return "/view";
		} catch (Exception e) {
			return "/view";
		}

	}

	// Delete
	@GetMapping(path = "/{idBlocoDeNotas}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String delete(@PathVariable("id") Integer id,
			@PathVariable("idBlocoDeNotas") Integer idBlocoDeNotas) {
		try {
			Optional<Usuario> usuario = getUsuarioById(id);

			if (!usuario.isPresent()) {
				return "/view";
			}

			Optional<BlocoDeNotas> bloco = service.findById(idBlocoDeNotas);

			if (id == bloco.get().getUsuario().getId() || !bloco.isPresent()) {
				return "/view";
			}

			service.delete(idBlocoDeNotas);

			return "/view";
		} catch (Exception e) {
			return "/view";
		}
	}
}