package com.principal.math.controller.services;

import java.util.List;

import org.hibernate.HibernateException;

import com.principal.math.model.repository.GenericRepository;

public class GenericService<E, Repository extends GenericRepository<E,Integer>> {

	private Repository r;

	public boolean verificaEntidade(E e) throws HibernateException {

		if (r.exists(e)) {
			return false;
		} else {
			return true;
		}
	}

	public void salvar(E e) throws HibernateException {

		if (verificaEntidade(e)) {
			r.save(e);
		} else {
			return;
		}
	}

	public boolean existePorId(Integer id) throws HibernateException {
		return r.existsById(id);
	}

	public List<E> retornarLista() throws HibernateException {
		return r.findAll();
	}

	public void deletar(Integer id) throws HibernateException {
		r.deleteById(id);
	}

	public void atualizar(E e, Integer id) {

		if (verificaEntidade(e)) {

			E novoE = r.getOne(id);
			novoE = e;
			r.save(novoE);

		} else {
			return;
		}
	}
}
