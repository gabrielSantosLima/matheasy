package com.principal.math.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.principal.math.enums.AnoCurso;
import com.principal.math.model.entity.Modulo;

@Repository
public interface ModuloRepository extends GenericRepository<Modulo, Integer> {
  
  List<Modulo> findByAno(AnoCurso ano);
  
  Optional<Modulo> findByTituloAndAno(String titulo, AnoCurso ano);
}
