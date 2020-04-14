package com.principal.math.controller;

import java.util.List;

import javax.validation.Valid;

import com.principal.math.controller.services.BlocoService;
import com.principal.math.model.entity.BlocoDeNotas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/card")
public class BlocoController {

  @Autowired
  private BlocoService service;
  
  private List<BlocoDeNotas> findAll(){
	  return service.listar();
  }
  
  @GetMapping
  public String prepareCard(Model model){
    model.addAttribute("cards", findAll()); 
    model.addAttribute("card", new BlocoDeNotas()); 
    return "cardTeste";
  }
  
  @PostMapping
  public void adicionarOuAtualizar(@Valid @ModelAttribute("card") BlocoDeNotas bloco){
    
    if(service.existsById(bloco.getId())){
      	service.atualizar(bloco, bloco.getId());
    }
    service.salvar(bloco);
  }

  @RequestMapping(value="/deletar/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
  public String deletar(@PathVariable("id") Integer id, Model model) {
  
    model.addAttribute("cards", findAll()); 
    model.addAttribute("card", new BlocoDeNotas()); 

	System.out.println("Passou por aqui");
	System.out.println(id);
	  
    if(service.existsById(id)){
    	
    	service.deletar(id);
    	model.addAttribute("cards", findAll()); 
    	
    	return "redirect:/card";
    }
    
    model.addAttribute("cards", findAll()); 
    return "redirect:/card";
  }
}