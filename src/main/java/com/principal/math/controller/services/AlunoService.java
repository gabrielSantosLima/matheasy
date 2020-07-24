package com.principal.math.controller.services;

import java.util.HashSet;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.principal.math.model.entity.Aluno;
import com.principal.math.model.entity.IUsuario;
import com.principal.math.model.repository.AlunoRepository;
import com.principal.math.model.repository.RoleRepository;

@Service
public class AlunoService extends GenericService<Aluno, AlunoRepository>{

	@Autowired
	private AlunoRepository repository;

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPassowrdEncoder;
	
	public Aluno save(IUsuario e) throws HibernateException {
		e.setPassword(bCryptPassowrdEncoder.encode(e.getPassword()));
		e.setRoles(new HashSet<>(roleRepository.findAll()));
		
		Aluno aluno = (Aluno) e;
		
		return repository.save(aluno);
	}
	
	public Aluno findByUsername(String username) {
		return repository.findByUsername(username);
	}
}
