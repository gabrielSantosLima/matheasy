package com.principal.math.controller.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.principal.math.model.entity.Aluno;
import com.principal.math.model.entity.BlocoDeNotas;
import com.principal.math.model.repository.AlunoRepository;
import com.principal.math.model.repository.BlocoRepository;
import com.principal.math.utils.EntidadeLogin;

@Service
public class AlunoService extends GenericService<Aluno, AlunoRepository> {

	@Autowired
	private BlocoRepository blocoRepository;

	public boolean login(EntidadeLogin entidade) {
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

	public List<BlocoDeNotas> getBlocoDeNotas(Aluno aluno){
		return blocoRepository.findByAluno(aluno);
	}
}
