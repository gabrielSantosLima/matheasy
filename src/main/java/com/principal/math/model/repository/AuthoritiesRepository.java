package com.principal.math.model.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.principal.math.model.entity.Authorities;

@Repository
public interface AuthoritiesRepository extends GenericRepository<Authorities, Integer>{

	Optional<Authorities> findByName(String name);
}
