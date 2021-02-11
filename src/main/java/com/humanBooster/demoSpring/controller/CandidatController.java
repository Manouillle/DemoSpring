package com.humanBooster.demoSpring.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import com.humanBooster.demoSpring.model.Etudiant;
import com.humanBooster.demoSpring.repository.CandidatRepository;
import com.humanBooster.demoSpring.services.CandidatService;

@Controller
@RequestMapping(path = "/candidat")
public class CandidatController {
	
	@Autowired
	private CandidatService candidatService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView candidat() {
		List<Etudiant> etudiants = this.candidatService.getCandidats();
		ModelAndView mv = new ModelAndView ("candidats-list");
		mv.addObject("etudiants", etudiants);
		return mv;
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView candidatDetail(@PathVariable(name="id") Long id) {
		Optional<Etudiant> etudiant =  this.candidatService.getCandidat(id);
		Etudiant etudiantObject;
		
		if(etudiant.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Etudiant Not Found");
			
		} else {
			 etudiantObject = etudiant.get();
		}
		ModelAndView mv = new ModelAndView("detail");
		mv.addObject("etudiant", etudiantObject);
		return mv;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addCandidatForm() {
		Etudiant etudiant = new Etudiant();
		ModelAndView mv = new ModelAndView ("candidat-add");
		mv.addObject("etudiant", etudiant);
		return mv;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveEtudiant(@Valid Etudiant etudiant, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "candidat-add";
		} else {
			this.candidatService.saveOrUpdateCandidat(etudiant);
			return "redirect:/candidat/";
		}
	}
	
	@RequestMapping(value = "/delete/{etudiant}", method = RequestMethod.GET)
	public String deleteEtudiant(@PathVariable(name = "etudiant") Etudiant etudiant) {
	  this.candidatService.deleteCandidat(etudiant);
	    return "redirect:/candidat/";
	}
	
	@RequestMapping(value = "/update/{etudiant}", method = RequestMethod.GET)
	public ModelAndView updateCandidatForm(@PathVariable(name ="etudiant") Etudiant etudiant) {
		
		ModelAndView mv = new ModelAndView ("candidat-update");
		mv.addObject("etudiant", etudiant);
		return mv;
	}
	
	@RequestMapping(value = "/update/{etudiant}", method = RequestMethod.POST)
	public String updateEtudiant(@Valid Etudiant etudiant, BindingResult bindingResult) {
		
		
		this.candidatService.saveOrUpdateCandidat(etudiant);
		if(bindingResult.hasErrors()) {
			return "candidat-update";
		} else {
			this.candidatService.saveOrUpdateCandidat(etudiant);
			return "redirect:/candidat/";
		}
	}
}
