package com.principal.math.controller;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.principal.math.controller.services.UsuarioService;
import com.principal.math.model.entity.Usuario;

@RestController
@RequestMapping(path= "/pontuacao" )
public class PontuacaoController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping(path = {"/",""})
	public ResponseEntity<Usuario> setPontuacao(Integer point) {
		try {
			Optional<Usuario> usuario = service.findByLoggedinUsername();
			
			if(!usuario.isPresent()) {
				return ResponseEntity.badRequest().build();				
			}
			
			usuario.get()
				.setPontuacao(usuario.get().getPontuacao() + point);
				
				service.update(
						usuario.get().getId(), 
						usuario.get()
						);
			
			return ResponseEntity.ok().build();
		}catch(Exception e){
			return ResponseEntity.status(402).build();
		}
		
	}
}
