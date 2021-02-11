package com.humanBooster.demoSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path="/")
public class SecurityContoller {
	
	@RequestMapping(value="/dashboard/{nom}/{prenom}", method = RequestMethod.GET)
	public ModelAndView testUrlParameter(
			@PathVariable(name = "nom") String nom,
			@PathVariable(name = "prenom") String prenom) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("candidats-list");
		mv.addObject("nom", nom);
		mv.addObject("prenom", prenom);
		
		return mv;
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView login() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		
		
		return mv;
	
	}
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public ModelAndView register() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("register");
		
		
		return mv;
	
	}
	
}
