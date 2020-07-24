package com.principal.math.controller.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.principal.math.model.entity.Aluno;
import com.principal.math.model.entity.BlocoDeNotas;
import com.principal.math.model.repository.BlocoRepository;

@Service
public class BlocoService extends GenericService<BlocoDeNotas, BlocoRepository> {

	@Autowired
	private BlocoRepository repository;
	
	public List<BlocoDeNotas> findByAluno(Aluno aluno){
		return repository.findByAluno(aluno);
	}
	
	public BlocoDeNotas save(BlocoDeNotas bloco, Aluno aluno) {
		bloco.setAluno(aluno);
		
		BlocoDeNotas createdBloco = save(bloco);
		
		return createdBloco;
	}
}
