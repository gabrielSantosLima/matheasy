package com.principal.math.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.principal.math.model.entity.Atividade;
import com.principal.math.model.entity.Modulo;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Integer>{
	
	List<Atividade> findByModulo(Modulo modulo);
}
