package com.principal.math.config;

import org.springframework.boot.ApplicationArguments;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.principal.math.model.entity.Authorities;
import com.principal.math.model.entity.Role;
import com.principal.math.model.repository.AuthoritiesRepository;
import com.principal.math.model.repository.RoleRepository;

@Component
@Order(1)
public class LoadRolesAndAuthorities implements ApplicationRunner{

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private AuthoritiesRepository authRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Authorities authBloco = createAuthoritiesIfNotFound("BLOCO_AUTH");
		Authorities authEventos = createAuthoritiesIfNotFound("EVENTOS_AUTH");
		Authorities authChat = createAuthoritiesIfNotFound("CHAT_AUTH");
		Authorities authModulos = createAuthoritiesIfNotFound("MODULOS_AUTH");
		Authorities authPerfil = createAuthoritiesIfNotFound("ALTERAR_PERFIL_AUTH");
		
		List<Authorities> authProfessor = new ArrayList<>();
		authProfessor.add(authBloco);
		authProfessor.add(authEventos);
		authProfessor.add(authChat);
		authProfessor.add(authPerfil);
		authProfessor.add(authModulos);

		List<Authorities> authAluno = new ArrayList<>();
		authAluno.add(authBloco);
		authAluno.add(authEventos);
		authAluno.add(authChat);
		authAluno.add(authPerfil);
		authAluno.add(authModulos);
		
		createRoleIfNotFound("ROLE_PROFESSOR", authProfessor);
		createRoleIfNotFound("ROLE_ALUNO", authAluno);
	}
	
	private Authorities createAuthoritiesIfNotFound(String name) {
		Optional<Authorities> auth = authRepository.findByName(name);
	
		if(auth.isPresent()) {
			return auth.get();
		}
		
		return authRepository.save(new Authorities(name));
	}

	private Role createRoleIfNotFound(String name, List<Authorities> authorities) {
		Optional<Role> role = roleRepository.findByName(name);
		
		if(role.isPresent()) {
			return role.get();
		}
		
		return roleRepository.save(new Role(name, authorities));
	}

}
