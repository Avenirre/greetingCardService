package com.gc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gc.repositories.TemplateRepository;
import com.gc.services.GreetingCardService;

@Controller
public class TemplateController {
	
	TemplateRepository templatesRepository;
	GreetingCardService greetingCardService;
	
	
	public TemplateController(TemplateRepository templatesRepository, 
			GreetingCardService greetingCardService) {
		this.templatesRepository = templatesRepository;
		this.greetingCardService = greetingCardService;
	}

	@GetMapping("/catalog")
	public String getCatalog(Model model) {
		model.addAttribute("templates", greetingCardService.getCatalog());
		return "index";
	}

}
