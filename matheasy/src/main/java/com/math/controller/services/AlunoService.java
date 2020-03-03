package com.math.controller.services;

import org.springframework.stereotype.Service;

import com.math.model.entity.Aluno;
import com.math.model.repository.AlunoRepository;

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
