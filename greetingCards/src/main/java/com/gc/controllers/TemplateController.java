package com.gc.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.gc.model.TemplateDto;
import com.gc.repositories.TemplateRepository;
import com.gc.services.TemplateService;

@Controller
public class TemplateController {
	
	TemplateRepository templatesRepository;
	TemplateService templateService;
	
	public TemplateController(TemplateRepository templatesRepository, 
			TemplateService templateService) {
		this.templatesRepository = templatesRepository;
		this.templateService = templateService;
	}

	@GetMapping("greetingcards/catalog")
	public String getCatalog(Model model) {
		model.addAttribute("templates", templateService.getCatalog());
		return "index";
	}
	
    @GetMapping("greetingcards/template/{id}/update")
    public String getTemplate(@PathVariable String id, Model model){
        model.addAttribute("template", templateService.findTemplateById(id));
        return "templateform";
    }
    
    @PostMapping("template")
    public String saveTemplate(@ModelAttribute("template") TemplateDto template, BindingResult bindingResult){
        templateService.updateAndSaveTemplate(template);
        return "redirect:/greetingcards/catalog";
    }

}
