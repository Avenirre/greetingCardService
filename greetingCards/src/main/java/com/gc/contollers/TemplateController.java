package com.gc.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gc.repositories.TemplateRepository;

@Controller
public class TemplateController {
	
	TemplateRepository templatesRepository;
	
	public TemplateController(TemplateRepository templatesRepository) {
		this.templatesRepository = templatesRepository;
	}

	@GetMapping("/catalog")
	public String getCatalog(Model model) {
		model.addAttribute("templates", templatesRepository.findAll());
		return "index";
	}

}
