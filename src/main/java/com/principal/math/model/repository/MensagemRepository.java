package com.principal.math.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.principal.math.model.entity.Mensagem;
import com.principal.math.model.entity.Usuario;

@Repository
public interface MensagemRepository extends JpaRepository<Mensagem, Integer>{
	
	List<Mensagem> findByUsuario1AndUsuario2OrUsuario2AndUsuario1(Usuario usuario1, Usuario usuario2, Usuario usuario3, Usuario usuario4);
}
