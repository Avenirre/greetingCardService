package com.gc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gc.model.TemplateDto;
import com.gc.services.TemplateService;

@Controller
@RequestMapping("greetingcards/")
public class TemplateController {
	
	TemplateService templateService;
	
	public TemplateController(TemplateService templateService) {
		this.templateService = templateService;
	}

	@GetMapping("catalog")
	public String getCatalog(Model model) {
		model.addAttribute("templates", templateService.getCatalog());
		return "index";
	}
	
    @GetMapping("template/{id}/update")
    public String getTemplate(@PathVariable String id, Model model){
        model.addAttribute("template", templateService.findTemplateById(id));
        return "templateform";
    }
    
    @PutMapping("template/{id}/update")
    public String saveTemplate(@ModelAttribute("template") TemplateDto template, @PathVariable String id){
        templateService.updateAndSaveTemplate(template);
        return "redirect:/greetingcards/catalog";
    }

}
