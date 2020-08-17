package com.principal.math.model.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.principal.math.model.entity.EstadoEstudo;
import com.principal.math.model.entity.Modulo;
import com.principal.math.model.entity.Usuario;

@Repository
public interface EstadoEstudoRepository extends GenericRepository<EstadoEstudo, Integer>{
	
	Optional<EstadoEstudo> findByUsuarioAndModulo(Usuario usuario, Modulo modulo);
}
