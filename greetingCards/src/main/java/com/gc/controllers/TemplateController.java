package com.gc.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.gc.exceptions.NotFoundException;
import com.gc.model.TemplateDto;
import com.gc.services.TemplateService;

import lombok.extern.slf4j.Slf4j;

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
    
	@ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception exception){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        return modelAndView;
    }

}
