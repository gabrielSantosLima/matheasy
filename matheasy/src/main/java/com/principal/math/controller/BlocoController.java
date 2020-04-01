package com.principal.math.controller;

import javax.validation.Valid;

import com.principal.math.controller.services.BlocoService;
import com.principal.math.model.entity.BlocoDeNotas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * BlocoController
 */
@Controller
@RequestMapping("/card")
public class BlocoController {

  @Autowired
  private BlocoService service;
  
  @GetMapping
  public String prepareCard(Model model){
    model.addAttribute("card", new BlocoDeNotas()); 
    return "card";
  }

  @GetMapping("/listar")
  public ModelAndView listar(){
    ModelAndView mv = new ModelAndView("card");
    mv.addObject("cards", service.listar());
    return mv;
  }

  @PostMapping
  public ResponseEntity adicionar(@Valid @ModelAttribute("card") BlocoDeNotas bloco){
    
    if(service.existsById(bloco.getId())){
      return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    service.salvar(bloco);
    return new ResponseEntity(HttpStatus.OK);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity deletar(@RequestParam("id") Integer id) {
    
    if(!service.existsById(id)){
      return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    service.deletar(id);
    return new ResponseEntity(HttpStatus.OK);
  }

  @PutMapping("/atualizar")
  public ResponseEntity atualizar(BlocoDeNotas bloco){
    
    if(!service.existsById(bloco.getId())){
      return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    service.atualizar(bloco, bloco.getId());
    return new ResponseEntity(HttpStatus.OK);
  }

}