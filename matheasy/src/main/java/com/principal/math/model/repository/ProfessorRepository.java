package com.principal.math.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.principal.math.model.entity.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

}
