package com.principal.math.controller.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class GenericService<E, Repository extends JpaRepository<E, Integer>> {
	
	@Autowired
	private Repository repository;
	
	public E save(E e) {
		
		E savedE = repository.save(e);
		
		return savedE;
	}
	
	public E update(Integer id, E e) throws Exception {
		
		if(e == null) {
			throw new Exception("[service] Erro ao atualizar!");
		}
		
		E newE = save(e);
		
		return newE;
	}
	
	public void delete(Integer id) throws Exception{
		repository.deleteById(id);
	}
	
	public Optional<E> findById(Integer id){
		Optional<E> e = repository.findById(id);
		
		return e;
	}
	
	public List<E> findAll(){
		return repository.findAll();
	}
}
