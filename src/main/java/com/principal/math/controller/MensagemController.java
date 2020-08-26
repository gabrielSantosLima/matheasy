package com.principal.math.controller;

import org.springframework.messaging.handler.annotation.Payload;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.principal.math.controller.services.MessagemService;
import com.principal.math.controller.services.UsuarioService;
import com.principal.math.model.entity.Mensagem;
import com.principal.math.model.entity.Usuario;
import com.principal.math.util.MessageModel;

@Controller
@CrossOrigin
public class MensagemController {
 
	@Autowired
	private SimpMessageSendingOperations template;
	
	@Autowired
	private MessagemService service;
	
	@Autowired
	private UsuarioService usuarioService;
	
    @MessageMapping("/chat/{id}")
    public void sendMessage(@DestinationVariable Integer id, @Payload MessageModel message) throws Exception {
    	System.out.println("Mensagem de "+ message.getFrom() +", de id: "+ message.getUserId());
    	
    	message.setDateToTime();
    	
    	service.save(message, id);
    	
    	template.convertAndSend("/queue/public/"+ id +"/"+ message.getUserId(), message);
    }
    
    @GetMapping("/chat/{idTo}/{idFrom}")
    @ResponseBody
    private List<MessageModel> list(@PathVariable Integer idTo, 
    		@PathVariable Integer idFrom){
    	List<Mensagem> mensagens = service.findByUsuario1AndUsuario2(idFrom, idTo);
    	List<MessageModel> models = new ArrayList<>();
    	
    	mensagens.stream().forEach(mensagem -> {
    		MessageModel message = new MessageModel(
    					mensagem.getMensagem(), 
    					mensagem.getData(), 
    					mensagem.getUsuario1().getNome(), 
    					mensagem.getUsuario2().getId()
    				);
    		
    		models.add(message);
    	});
    	
    	return models;
    }
    
    @GetMapping("/mensagens")
    public ModelAndView view() {
    	ModelAndView mv = new ModelAndView("Chat/index");
    	
    	try {
			Optional<Usuario> usuario = usuarioService.findByLoggedinUsername();
			
			mv.addObject("usuario", usuario.get());
		} catch (Exception e) {
			e.printStackTrace();
			
		}
    	return mv;
    }
}
