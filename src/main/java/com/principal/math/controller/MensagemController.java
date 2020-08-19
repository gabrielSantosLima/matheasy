package com.principal.math.controller;

import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.principal.math.util.MessageModel;

@Controller
public class MensagemController {
 
    @MessageMapping("/chat")
    @SendTo("/queue/public")
    public MessageModel sendMessage(@Payload MessageModel message) throws Exception {
    	System.out.println("Mensagem de "+ message.getFrom() +", de id: "+ message.getUserId());
    	
    	message.setDateToTime();
    	
    	return message;
    }
}
