package com.principal.math.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/blocos")
public class BlocoController {

	@Autowired
	private BlocoService service;

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/view")
	public ModelAndView view() {
		ModelAndView mv = new ModelAndView("Card/index");
		try {
			Optional<Usuario> usuario = usuarioService.findByLoggedinUsername();

			System.out.println(usuario.get().getUsername());
			
			List<BlocoDeNotas> blocos = service.findByUsuario(usuario.get());
			
			mv.addObject("id", usuario.get().getId());
			mv.addObject("card", new BlocoDeNotas());
			mv.addObject("cards", blocos);			
			
		}catch(Exception e) {
			e.printStackTrace();			
		}
		return mv;			
	}

	// List
	@GetMapping("/")
	public List<BlocoDeNotas> list() {
		try {			
			Optional<Usuario> usuario = usuarioService.findByLoggedinUsername();
	
			if (!usuario.isPresent()) {
				return new ArrayList<>();
			}
	
			List<BlocoDeNotas> blocos = service.findByUsuario(usuario.get());
			
			return blocos;
		}catch(Exception e) {
			e.printStackTrace();
			
			return new ArrayList<>();
		}
	}

	// Create
	@PostMapping(path = "/")
	public String create(@ModelAttribute("card") BlocoDeNotas blocoDeNotas) {
		try {
			Optional<Usuario> usuario = usuarioService.findByLoggedinUsername();

			if (!usuario.isPresent()) {
				return "redirect:/blocos/view";
			}

			service.save(blocoDeNotas, usuario.get());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/blocos/view";
	}

	// Update
	@PostMapping(path = "/{id}")
	public String update(@ModelAttribute("card") BlocoDeNotas blocoDeNotas, @PathVariable("id") Integer id) {
		try {
			Optional<Usuario> usuario = usuarioService.findByLoggedinUsername();

			if (!usuario.isPresent()) {
				return "Card/index";
			}

			Optional<BlocoDeNotas> bloco = service.findById(id);

			if (usuario.get().getId() == bloco.get().getUsuario().getId() || !bloco.isPresent()) {
				return "redirect:/blocos/view";
			}

			service.update(id, blocoDeNotas);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/blocos/view";

	}

	// Delete
	@GetMapping(path = "/{id}")
	public String delete(@PathVariable("id") Integer id) {
		try {

			service.delete(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/blocos/view";
	}
}