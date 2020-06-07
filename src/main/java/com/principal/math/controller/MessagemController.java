package com.principal.math.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class MessagemController {
	
	@Autowired
	private SimpMessagingTemplate simpleMessagingTemplate;
	
	@MessageMapping("/chat.send")
	@SendTo("/topic/public")
	public void sendMessage() {
		
	}
}
