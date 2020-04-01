package com.principal.math.controller.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class GenericService<E, Repository extends JpaRepository<E, Integer>> {

	@Autowired
	private Repository r;
	
	public void salvar(E e) throws HibernateException {
		r.save(e);
	}

	public List<E> listar() throws HibernateException {
		return r.findAll();
	}

	public void deletar(Integer id) throws HibernateException {
		r.deleteById(id);
	}

	public void atualizar(E e, Integer id) {

		if (r.existsById(id)) {

			E novoE = r.getOne(id);
			novoE = e;
			r.save(novoE);
		} else {
			return;
		}
	}
	
	public boolean existsById(Integer id) {
		return r.existsById(id);
	}

	public Optional<E> retornarEntidadePorId(Integer id){
		return r.findById(id);
	}
}
