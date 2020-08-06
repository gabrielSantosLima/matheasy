package com.principal.math.controller.services;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.principal.math.model.entity.IUsuario;
import com.principal.math.model.entity.Professor;
import com.principal.math.model.repository.ProfessorRepository;
import com.principal.math.model.repository.RoleRepository;

@Service
public class ProfessorService extends GenericService<Professor, ProfessorRepository> {
	
	@Autowired
	private ProfessorRepository repository;

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPassowrdEncoder;
	
	public Professor save(IUsuario e) throws HibernateException {
		e.setPassword(bCryptPassowrdEncoder.encode(e.getPassword()));
		e.setRole(roleRepository.findByName("ROLE_ADMIN"));
		
		Professor professor = (Professor) e;
		
		return repository.save(professor);
	}
	
	public Professor findByUsername(String username) {
		return repository.findByUsername(username);
	}
}
