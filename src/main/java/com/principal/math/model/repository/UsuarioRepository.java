package com.principal.math.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.principal.math.model.entity.Role;
import com.principal.math.model.entity.Usuario;

@Repository
public interface UsuarioRepository extends GenericRepository<Usuario, Integer>{
	
	Optional<Usuario> findByUsername(String username);

	List<Usuario> findContatosById(Integer id);
	
	List<Usuario> findTop10ByRoleOrderByPontuacaoDesc(Role role);
	
	List<Usuario> findTop10ByOrderByPontuacaoDesc();
}
