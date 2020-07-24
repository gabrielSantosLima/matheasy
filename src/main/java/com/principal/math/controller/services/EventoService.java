package com.principal.math.controller.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.principal.math.model.entity.Aluno;
import com.principal.math.model.entity.Evento;
import com.principal.math.model.repository.EventoRepository;

@Service
public class EventoService extends GenericService<Evento, EventoRepository> {

	@Autowired 
	private EventoRepository repository;
	
	public List<Evento> findByAluno(Aluno aluno){
		return repository.findByAluno(aluno);
	}
	
	public Evento save(Evento evento, Aluno aluno) {
		evento.setAluno(aluno);
		
		Evento createdEvento = save(evento);
		
		return createdEvento;
	}
}
