package com.principal.math.config;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.principal.math.controller.services.UsuarioService;
import com.principal.math.model.entity.Usuario;

@Component
@SuppressWarnings(value = "unused")
@Order(2)
public class LoadUserExample implements ApplicationRunner{

	@Autowired
	private UsuarioService service;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Usuario professor = createUserIfNotExists(
				new Usuario(
						"professor",
						new Date(),
						"professor",
						"exemplo@gmail.com",
						"Eu sou um exemplo de professor, formado em Matemática",
						"123",
						"123",
						null
				), 
				"ROLE_PROFESSOR"
		);
		
		Usuario aluno = createUserIfNotExists(
				new Usuario(
						"aluno",
						new Date(),
						"aluno",
						"exemplo2@gmail.com",
						"Aluno não terá descrição",
						"123",
						"123",
						null), 
				"ROLE_ALUNO"
		);
		
	}
	
	private Usuario createUserIfNotExists(Usuario newUsuario, String role) {
		Optional<Usuario> usuario = service.findByUsername(newUsuario.getUsername());
	
		if(usuario.isPresent()) {
			return usuario.get();
		}
		
		return service.save(newUsuario, role);
	}

}
