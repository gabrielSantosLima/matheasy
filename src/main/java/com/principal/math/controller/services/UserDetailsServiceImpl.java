package com.principal.math.controller.services;

import java.util.Set;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.principal.math.model.entity.IUsuario;
import com.principal.math.model.repository.AlunoRepository;
import com.principal.math.model.repository.ProfessorRepository;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private ProfessorRepository professorRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		IUsuario usuario = alunoRepository.findByUsername(username);

		if (usuario == null) {
			usuario = professorRepository.findByUsername(username);
		}

		if (usuario == null)
			throw new UsernameNotFoundException(username);

		Set<GrantedAuthority> grantedAuthority = new HashSet<>();
		grantedAuthority.add(new SimpleGrantedAuthority(usuario.getRole().getName()));
		
		return new User(usuario.getUsername(), usuario.getPassword(), grantedAuthority);
	}

}
