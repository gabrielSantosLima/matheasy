package com.principal.math.model.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.principal.math.model.entity.Role;

@Repository
public interface RoleRepository extends GenericRepository<Role, Long>{

	Optional<Role> findByName(String name);
	
}
