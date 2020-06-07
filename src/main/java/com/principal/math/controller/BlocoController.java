package com.principal.math.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.principal.math.controller.services.BlocoService;
import com.principal.math.model.entity.Aluno;
import com.principal.math.model.entity.BlocoDeNotas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * BlocoController
 */
@Controller
@RequestMapping("aluno/homepage/card")
public class BlocoController {

	@Autowired
	private BlocoService service;

	private Aluno alunoLogado;

	private List<BlocoDeNotas> findByAluno() {
		return service.findByAluno(alunoLogado);
	}

	@GetMapping
	public String initialize(Model model, HttpSession session) {
		alunoLogado = (Aluno) session.getAttribute("aluno");

		model.addAttribute("cards", findByAluno());
		model.addAttribute("card", new BlocoDeNotas());
		model.addAttribute("template", "card");

		return "homepage";
	}

	@PostMapping("/{id}")
	public String adicionar(@PathVariable("id") Integer id, @Valid @ModelAttribute("card") BlocoDeNotas bloco) {

		if (service.existsById(id)) {
			service.atualizar(bloco, id);
			return "redirect:/aluno/homepage/card";
		}

		service.salvarBlocoDeNotas(bloco, alunoLogado);
		return "redirect:/aluno/homepage/card";
	}

	@RequestMapping(value = "/deletar/{id}", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deletar(@PathVariable("id") Integer id) {

		BlocoDeNotas bloco = service.getEntityById(id).get();

		if (service.existsById(id)) {
			service.deletarBlocoDeNotas(bloco);
		}

		return "redirect:/aluno/homepage/card";
	}
}