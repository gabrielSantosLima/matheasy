package com.principal.math.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.principal.math.controller.services.UsuarioService;
import com.principal.math.model.entity.Usuario;

@Controller("/aluno/pontuacao")
public class PontuacaoController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping(path = {"/", ""}, consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> setPontuacao(@RequestBody Integer point, HttpSession session) {
		Integer id = (Integer) session.getAttribute("USER_ID");
		Usuario usuario = usuarioService.findById(id).get();
		
		try {
			
			usuario.setPontuacao(usuario.getPontuacao() + point);
			Usuario updatedUsuario = usuarioService.update(id, usuario);
			
			return ResponseEntity.ok(updatedUsuario);
		}catch(Exception e){
			return ResponseEntity.badRequest().build();
		}
		
	}
}
