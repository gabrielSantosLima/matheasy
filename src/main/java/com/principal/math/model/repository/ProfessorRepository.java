package com.principal.math.model.repository;

import org.springframework.stereotype.Repository;

import com.principal.math.model.entity.Professor;

@Repository
public interface ProfessorRepository extends GenericRepository<Professor, Integer> {
	Professor findByUsername(String username);
}
