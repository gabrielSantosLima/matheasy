package com.principal.math.model.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.principal.math.model.entity.Aluno;
import com.principal.math.model.entity.Evento;

@Repository
public interface EventoRepository extends GenericRepository<Evento, Integer> {

	List<Evento> findByAluno(Aluno aluno);
}
