package com.principal.math.controller.services;

import org.springframework.stereotype.Service;

import com.principal.math.model.entity.Aluno;
import com.principal.math.model.repository.AlunoRepository;

@Service
public class AlunoService {

	private AlunoRepository ar;

	public boolean verificaAluno(Aluno aluno) {

		if (ar.exists(aluno)) {
			return false;
		} else {
			return true;
		}
	}
	
	public void salvar(Aluno aluno) {
		
		
	}
}
