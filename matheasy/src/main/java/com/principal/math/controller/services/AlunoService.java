package com.principal.math.controller.services;

import org.springframework.stereotype.Service;

import com.principal.math.model.entity.Aluno;
import com.principal.math.model.repository.AlunoRepository;
import com.principal.math.utils.EntidadeLogin;

@Service
public class AlunoService extends GenericService<Aluno, AlunoRepository> {

	public boolean verificarAtributosParaLogin(EntidadeLogin entidade) {
		try {
			for (Aluno aluno : this.listar()) {
				if (aluno.comparaAtributosLogin(entidade.getEmail(), entidade.getSenha())) {
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			System.out.println("Erro : " + e.getMessage());
			return false;
		}
	}
}
