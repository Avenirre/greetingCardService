package com.gc.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection="templates")
@Data
public class Template {
	
	private String id;
	private String event;
	private String text;
	
	public Template(TemplateDto templateDto) {
		this.id = templateDto.getId();
		this.event = templateDto.getEvent();
		this.text = templateDto.getText();
	}
}
