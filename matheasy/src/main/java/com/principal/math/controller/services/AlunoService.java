package com.principal.math.controller.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.principal.math.model.entity.Aluno;
import com.principal.math.model.repository.AlunoRepository;

@Service
public class AlunoService extends GenericService<Aluno, AlunoRepository> {

	private AlunoRepository ar;

	public boolean verificarAtributosParaLogin(Aluno alunoRequest) {
		List<Aluno> alunos = ar.findAll();

		for (Aluno aluno : alunos) {
			if (aluno.comparaAtributosLogin(alunoRequest.getEmail(), alunoRequest.getSenha())) {
				return true;
			}
		}

		return false;
	}

	public Aluno retornaAluno(Aluno aluno) {
		for (Aluno a : ar.findAll()) {
			if (a.comparaAtributosLogin(aluno.getEmail(), aluno.getSenha()))
				return a;
		}

		return new Aluno();
	}
}
