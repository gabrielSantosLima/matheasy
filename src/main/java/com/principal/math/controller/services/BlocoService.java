package com.principal.math.controller.services;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.principal.math.model.entity.BlocoDeNotas;
import com.principal.math.model.entity.Usuario;
import com.principal.math.model.repository.BlocoRepository;

@Service
public class BlocoService extends GenericService<BlocoDeNotas, BlocoRepository> {

	@Autowired
	private BlocoRepository repository;
	
	public List<BlocoDeNotas> findByUsuario(Usuario usuario){
		return repository.findByUsuario(usuario);
	}
	
	public BlocoDeNotas save(BlocoDeNotas bloco, Usuario usuario) {
		bloco.setUsuario(usuario);
		
		BlocoDeNotas createdBloco = save(bloco);
		
		return createdBloco;
	}
}
