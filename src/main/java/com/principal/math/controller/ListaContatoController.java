package com.principal.math.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.principal.math.controller.services.UsuarioService;
import com.principal.math.model.entity.Usuario;

@Controller
@CrossOrigin
@RequestMapping("/contatos")
public class ListaContatoController {
	
	@Autowired
	private UsuarioService service;

	@GetMapping(path = {"/view"})
	public ModelAndView view(String role) {
		ModelAndView mv = new ModelAndView("Contatos/index");
		
		try {
			Optional<Usuario> usuario = service.findByLoggedinUsername();
			
			if(role != null ) {
				List<Usuario> usuarios = service.findByRoleOrderByPontuacaoDesc(role);
				
				mv.addObject("contatos", usuario.get().getContatos());
				mv.addObject("usuarios", usuarios);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return mv;
	}
	
	@GetMapping(path = {"/{idContato}"})
	public String create(@PathVariable Integer idContato){
		try {
			Optional<Usuario> usuario = service.findByLoggedinUsername();
			Optional<Usuario> contato = service.findById(idContato);		
			
			System.out.println(contato.get().getNome());
			
			if(!usuario.isPresent() || !contato.isPresent()) {
				return "redirect:/mensagens";
			}
			
			service.addContato(usuario.get(), contato.get());
			
			return "redirect:/mensagens";			
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/mensagens";
		}
	}
	
	@GetMapping(path = {"/remove/{idContato}"})
	public String delete(@PathVariable Integer idContato){
		try {
			Optional<Usuario> usuario = service.findByLoggedinUsername();
			Optional<Usuario> contato = service.findById(idContato);		
			
			if(!usuario.isPresent() || !contato.isPresent()) {
				return "redirect:/mensagens";
			}
			
			service.removeContato(usuario.get(), contato.get());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/mensagens";			
	}
	
}
