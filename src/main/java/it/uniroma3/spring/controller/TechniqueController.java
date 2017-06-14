package it.uniroma3.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.spring.model.Technique;
import it.uniroma3.spring.service.TechniqueService;


@Controller
public class TechniqueController  {
	
    @Autowired
    private TechniqueService techniqueservice; 

    @GetMapping("/technique/add")
    public String showForm(Technique technique) {
        return "formtechnique";
    }

    @PostMapping("/technique/add")
    public String checkTechniqueInfo(@Valid @ModelAttribute Technique technique, 
    									BindingResult bindingResult, Model model) {
    	
        if (bindingResult.hasErrors()) {
            return "formtechnique";
        }
        else {
        	model.addAttribute(technique);
            techniqueservice.add(technique); 
        }
        return "formtechnique";
    }
}