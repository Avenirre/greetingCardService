package com.gc.services;

import java.util.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gc.exceptions.NotFoundException;
import com.gc.model.Template;
import com.gc.model.TemplateDto;
import com.gc.repositories.TemplateRepository;

@Service
public class TemplateService {
	
	TemplateRepository templates;
	
	public TemplateService(TemplateRepository templates) {
		this.templates = templates;
	}

	public List<Template> getCatalog() {
		List<Template> result = new ArrayList<>();
		templates.findAll().iterator().forEachRemaining(result::add);
		Collections.sort(result,(Template t1, Template t2) ->{
	        return t1.getId().compareToIgnoreCase(t2.getId());
	});
		return result;
	}
	
    public TemplateDto findTemplateById(String id) {
        Optional<Template> templateOptional = templates.findById(id);
        if (!templateOptional.isPresent()) {
            throw new NotFoundException("Template Not Found. For ID value: " + id);
        }
        return new TemplateDto(templateOptional.get());
    }
    
    @Transactional
    public void updateAndSaveTemplate(TemplateDto templateDto) {
        Template changingTemplate = templates.findById(templateDto.getId()).get();
        changingTemplate.setText(templateDto.getText());
        templates.save(changingTemplate);
    }
}
