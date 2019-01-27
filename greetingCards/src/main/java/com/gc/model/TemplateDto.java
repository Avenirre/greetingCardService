package com.gc.model;

import java.io.Serializable;

import lombok.Data;


@Data
public class TemplateDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Long id;
	String event;
	String text;
	
	
	public TemplateDto(Template template) {
		this.id = template.id;
		this.event = template.event;
		this.text = template.text;
	}
}
