package com.principal.math.controller.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.principal.math.enums.AnoCurso;
import com.principal.math.model.entity.Modulo;
import com.principal.math.model.repository.ModuloRepository;

@Service
public class ModuloService extends GenericService<Modulo, ModuloRepository> {
	
	@Autowired
	private ModuloRepository repository;
	
	public Optional<Modulo> findByTituloAndAno(String titulo, Integer ano) {
		return repository.findByTituloAndAno(titulo, AnoCurso.of(ano));
	}

	public List<Modulo> findByAno(Integer ano) {
		return repository.findByAno(AnoCurso.of(ano));
	}
	
}
