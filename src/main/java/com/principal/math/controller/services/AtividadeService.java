package com.principal.math.controller.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.principal.math.model.entity.Atividade;
import com.principal.math.model.entity.Modulo;
import com.principal.math.model.repository.AtividadeRepository;

@Service
public class AtividadeService extends GenericService<Atividade, AtividadeRepository>{
	
	@Autowired
	private AtividadeRepository repository;
	
	public List<Atividade> findByModulo(Modulo modulo){
		return repository.findByModulo(modulo);
	}
	
	public Atividade save(Atividade atividade, Modulo modulo) {
		atividade.setModulo(modulo);
		
		Atividade createdAtividade = save(atividade);
		
		return createdAtividade;
	}
}
