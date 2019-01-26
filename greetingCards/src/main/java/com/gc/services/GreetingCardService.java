package com.gc.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gc.model.Template;
import com.gc.repositories.TemplateRepository;

@Service
public class GreetingCardService {
	
	TemplateRepository templates;
	
	public GreetingCardService(TemplateRepository templates) {
		this.templates = templates;
	}

	public Set<Template> getCatalog() {
		Set<Template> result = new HashSet<>();
		templates.findAll().iterator().forEachRemaining(result::add);
		return result;
	}


	

}
