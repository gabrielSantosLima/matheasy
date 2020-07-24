package com.principal.math.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.principal.math.model.entity.Aluno;
import com.principal.math.model.entity.ListaContato;
import com.principal.math.model.entity.Professor;

@Repository
public interface ListaContatoRepository extends JpaRepository<ListaContato, Integer>{
	
	Optional<ListaContato> findByAlunoAndProfessor(Aluno aluno, Professor professor);

	List<ListaContato> findByAluno(Aluno aluno);
	
	List<ListaContato> findByProfessor(Professor professor);
}
