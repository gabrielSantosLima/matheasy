package com.principal.math.controller.services;

import java.util.HashSet;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
	
	@Override
	public Professor salvar(Professor e) throws HibernateException {
		e.setPassword(bCryptPassowrdEncoder.encode(e.getPassword()));
		e.setRoles(new HashSet<>(roleRepository.findAll()));
		return repository.save(e);
	}
	
	public Professor findByUsername(String username) {
		return repository.findByUsername(username);
	}
}
