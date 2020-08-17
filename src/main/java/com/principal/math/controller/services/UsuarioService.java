package com.principal.math.controller.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.principal.math.model.entity.Usuario;
import com.principal.math.model.repository.RoleRepository;
import com.principal.math.model.repository.UsuarioRepository;

@Service
public class UsuarioService extends GenericService<Usuario, UsuarioRepository>{
	
	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPassowrdEncoder;
	
	public Usuario save(Usuario e, String roleName) throws HibernateException {
		e.setPassword(bCryptPassowrdEncoder.encode(e.getPassword()));
		e.setPontuacao(0);
		e.setRole(roleRepository.findByName(roleName).get());
		
		return repository.save(e);
	}
	
	public Optional<Usuario> findByUsername(String username) {
		return repository.findByUsername(username);
	}
	
	public List<Usuario> findTop10ByOrderByPontuacaoDesc(){
		return repository.findTop10ByOrderByPontuacaoDesc();
	}
}
