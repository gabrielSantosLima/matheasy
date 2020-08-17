package com.principal.math.controller.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.principal.math.model.entity.Role;
import com.principal.math.model.entity.Usuario;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioService usuarioService;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioService.findByUsername(username);

		if (!usuario.isPresent()) {
			throw new UsernameNotFoundException(username);			
		}
		
		List<GrantedAuthority> grantedAuthority = getAuthorities(
				usuario.get().getRole()
		);
		
		return new User(
				usuario.get().getUsername(), 
				usuario.get().getPassword(), 
				grantedAuthority
		);
	}
	
	private List<GrantedAuthority> getAuthorities(Role role){
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		authorities.add(new SimpleGrantedAuthority(role.getName()));
		
		role.getAuthorities()
		.stream()
		.map(p -> new SimpleGrantedAuthority(p.getName()))
		.forEach(authorities::add);
	
		return authorities;
	}
	
}
