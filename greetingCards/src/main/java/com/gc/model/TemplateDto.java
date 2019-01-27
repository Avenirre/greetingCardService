package com.gc.model;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class TemplateDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String event;
	private String text;
	
	public TemplateDto() {}
	
	public TemplateDto(Template template) {
		this.id = template.getId();
		this.event = template.getEvent();
		this.text = template.getText();
	}
}
