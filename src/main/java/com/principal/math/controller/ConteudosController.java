package com.principal.math.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ConteudosController {
	
	@GetMapping(path = "/conteudo/{ano}/{conteudo}", produces = MediaType.TEXT_HTML_VALUE)
	public String getTextFromHtmlPage(@PathVariable Integer ano, @PathVariable String conteudo) {
		return "Conteudos/"+ ano +"/"+ conteudo;
	}
}
