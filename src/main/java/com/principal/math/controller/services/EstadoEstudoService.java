package com.principal.math.controller.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.principal.math.model.entity.EstadoEstudo;
import com.principal.math.model.entity.Modulo;
import com.principal.math.model.entity.Usuario;
import com.principal.math.model.repository.EstadoEstudoRepository;

@Service
public class EstadoEstudoService extends GenericService<EstadoEstudo, EstadoEstudoRepository>{
	
	@Autowired
	private EstadoEstudoRepository repository;
	
	
	public EstadoEstudo save(Usuario usuario, Modulo modulo) {
		return repository.save(new EstadoEstudo(usuario, modulo));
	}
	
	public void delete(Usuario usuario, Modulo modulo) throws Exception {
		Optional<EstadoEstudo> ee = repository.findByUsuarioAndModulo(usuario, modulo);
		
		if(!ee.isPresent()) {
			throw new Exception("[estado-estudo-service] Erro ao deletar entidade!");
		}
		
		repository.delete(ee.get());
	}
}
