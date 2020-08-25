package com.principal.math.controller.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.principal.math.model.entity.Mensagem;
import com.principal.math.model.entity.Usuario;
import com.principal.math.model.repository.MensagemRepository;
import com.principal.math.util.MessageModel;

@Service
public class MessagemService extends GenericService<Mensagem, MensagemRepository>{
	
	@Autowired
	public UsuarioService usuarioService;
	
	@Autowired
	private MensagemRepository repository;
	
	public Mensagem save(MessageModel message, Integer toId) {
		Optional<Usuario> to = usuarioService.findById(toId);
		Optional<Usuario> from = usuarioService.findById(message.getUserId());
		
		Mensagem mensagem = save(new Mensagem(
					message.getContent(),
					message.getTime(),
					from.get(),
					to.get()
				));
		
		return mensagem;
	}
	
	public List<Mensagem> findByUsuario1AndUsuario2(Integer usuario1, Integer usuario2){
		Optional<Usuario> from = usuarioService.findById(usuario1);
		Optional<Usuario> to = usuarioService.findById(usuario2);
		List<Mensagem> mensagens  = repository.findByUsuario1AndUsuario2OrUsuario2AndUsuario1(
				from.get(), 
				to.get(),
				from.get(),
				to.get()
			);
		
		return mensagens;
	}
}
