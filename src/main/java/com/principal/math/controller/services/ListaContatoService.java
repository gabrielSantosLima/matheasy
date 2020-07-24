package com.principal.math.controller.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.principal.math.model.entity.Aluno;
import com.principal.math.model.entity.ListaContato;
import com.principal.math.model.entity.Professor;
import com.principal.math.model.repository.ListaContatoRepository;

@Service
public class ListaContatoService extends GenericService<ListaContato, ListaContatoRepository>{
	
	@Autowired
	private ListaContatoRepository repository;
	
	public ListaContato save(Aluno aluno, Professor professor) {
		ListaContato lc = new ListaContato(professor, aluno);
		
		ListaContato createdListaContato = save(lc);

		
		return createdListaContato;
	}
	
	public void delete(Aluno aluno, Professor professor) throws Exception {
		Optional<ListaContato> ls = repository.findByAlunoAndProfessor(aluno, professor);
		
		if(!ls.isPresent()) {
			throw new Exception("[lista-contato-service] Erro ao deletar entidade!");
		}
		
		repository.delete(ls.get());
	}
	
	public List<ListaContato> findByAluno(Aluno aluno){
		return repository.findByAluno(aluno);
	}

	public List<ListaContato> findByProfessor(Professor professor){
		return repository.findByProfessor(professor);
	}
}
