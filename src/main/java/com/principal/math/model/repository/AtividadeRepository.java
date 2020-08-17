package com.principal.math.model.repository;


import java.util.List;
import org.springframework.stereotype.Repository;

import com.principal.math.model.entity.Atividade;
import com.principal.math.model.entity.Modulo;

@Repository
public interface AtividadeRepository extends GenericRepository<Atividade, Integer>{
	
	List<Atividade> findByModulo(Modulo modulo);
}
