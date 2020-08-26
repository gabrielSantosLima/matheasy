package com.principal.math.controller;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.principal.math.controller.services.ModuloService;
import com.principal.math.enums.AnoCurso;
import com.principal.math.model.entity.Modulo;

@Controller
@RequestMapping("/modulo")
public class ModuloController {

	@Autowired
	private ModuloService service;

	@GetMapping("/{ano}")
	public ModelAndView getModulos(@PathVariable("ano") Integer ano) {
		ModelAndView mv = new ModelAndView("Modulo/index");
		List<Modulo> modulos = service.findByAno(ano);

		if (modulos.isEmpty()) {
			mv.addObject("mensagem", "Nenhum módulo cadastrado!");
			return mv;
		}

		mv.addObject("modulos", modulos);
		mv.addObject("ano", ano);
		return mv;
	}

	@GetMapping(path="/{ano}/{conteudo}")
	public ModelAndView getModulo(@PathVariable String conteudo,
			@PathVariable Integer ano) {
		ModelAndView mv = new ModelAndView("Assuntos/index");
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/conteudo/" + ano + "/" + conteudo;

		
		try {
			Modulo modulo = service.findBySiglaAndAno(AnoCurso.of(ano), conteudo).get();

			HttpMessageConverter<?> stringHttpMessageConverter = new StringHttpMessageConverter(
					Charset.forName("UTF-8"));
			List<HttpMessageConverter<?>> httpMessageConverter = new ArrayList<>();
			httpMessageConverter.add(stringHttpMessageConverter);
			restTemplate.setMessageConverters(httpMessageConverter);

			HttpHeaders headers = new HttpHeaders();
			Charset utf8 = Charset.forName("UTF-8");
			MediaType mediaType = new MediaType("text", "html", utf8);
			headers.setContentType(mediaType);

			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

			String conteudoRecebido = restTemplate
					.exchange(url, HttpMethod.GET, entity, String.class).getBody();

			System.out.print(conteudoRecebido);

			if (conteudoRecebido != "") {
				mv.addObject("conteudo", conteudoRecebido);
				mv.addObject("modulo", modulo);
				return mv;
			}
			
			
			mv.addObject("conteudo", "<h1>Modulo não existe</h1>");
			return mv;
		} catch (Exception e) {
			mv.addObject("conteudo", "<h1>Modulo não existe</h1>");
			return mv;
		}
	}
}
