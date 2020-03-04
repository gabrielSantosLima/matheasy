package com.principal.math.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class WebController {
	
	public ModelAndView index() {
		return new ModelAndView("index");
	}
}
