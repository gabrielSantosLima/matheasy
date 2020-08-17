package com.principal.math.model.repository;


import java.util.List;
import org.springframework.stereotype.Repository;

import com.principal.math.model.entity.Evento;
import com.principal.math.model.entity.Usuario;

@Repository
public interface EventoRepository extends GenericRepository<Evento, Integer> {

	List<Evento> findByUsuario(Usuario usuario);
}
