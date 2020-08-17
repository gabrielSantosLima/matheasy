package com.principal.math.model.repository;


import org.springframework.stereotype.Repository;
import java.util.List;

import com.principal.math.model.entity.BlocoDeNotas;
import com.principal.math.model.entity.Usuario;

@Repository
public interface BlocoRepository extends GenericRepository<BlocoDeNotas, Integer>{

  List<BlocoDeNotas> findByUsuario(Usuario usuario);
  
}
