package com.principal.math.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.principal.math.controller.services.UsuarioService;
import com.principal.math.model.entity.Usuario;

@Controller
@RequestMapping("/lista-contato")
public class ListaContatoController {
	
	@Autowired
	private UsuarioService service;
	
	private Optional<Usuario> getContatoById(Integer id){
		return service.findById(id);
	}

	@GetMapping(path = {"/", ""})
	public ModelAndView list() {
		try {
			ModelAndView mv = new ModelAndView("Contatos/index"); // Mudar página
			Optional<Usuario> usuario = service.findByLoggedinUsername();
			
			if(usuario.isPresent()) {
				List<Usuario> contatos = service.findContatosById(
						usuario.get().getId()
				);				
				mv.addObject("contatos", contatos);
			}			
			
			return mv;
		}catch(Exception e) {
			e.printStackTrace();
			
			return new ModelAndView();
		}
	}
	
	@PostMapping(path = {"/{idContato}"}, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> create(@PathVariable Integer idContato){
		try {
			Optional<Usuario> usuario = service.findByLoggedinUsername();
			Optional<Usuario> contato = getContatoById(idContato);		
			
			if(!usuario.isPresent() || !contato.isPresent()) {
				return ResponseEntity.badRequest().build();
			}
			
			usuario.get().getContatos().add(contato.get());
			
			Usuario updatedUsuario = service.update(
					usuario.get().getId(), 
					usuario.get()
			);
			
			return ResponseEntity.ok(updatedUsuario);			
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();			
		}
	}
	
	@GetMapping(path = {"/idContato"}, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> delete(@PathVariable Integer idContato){
		try {
			Optional<Usuario> usuario = service.findByLoggedinUsername();
			Optional<Usuario> contato = getContatoById(idContato);		
			
			if(!usuario.isPresent() || !contato.isPresent()) {
				return ResponseEntity.badRequest().build();
			}
			
			usuario.get().getContatos().remove(contato.get());
			
			Usuario updatedUsuario = service.update(
					usuario.get().getId(), 
					usuario.get()
			);
			
			return ResponseEntity.ok(updatedUsuario);			
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();			
		}
	}
	
}
