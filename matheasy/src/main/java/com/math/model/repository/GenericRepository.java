package com.math.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericRepository<E, Id> extends JpaRepository<E, Id> {
	
	<S extends E> boolean exists(S s);
}
