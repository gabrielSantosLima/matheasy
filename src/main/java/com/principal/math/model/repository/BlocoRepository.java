package com.principal.math.model.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import com.principal.math.model.entity.Aluno;
import com.principal.math.model.entity.BlocoDeNotas;

@Repository
public interface BlocoRepository extends GenericRepository<BlocoDeNotas, Integer>{

  List<BlocoDeNotas> findByAluno(Aluno aluno);
  
}
