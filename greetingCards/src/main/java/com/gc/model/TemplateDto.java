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
	
	Long id;
	String text;
	
	public TemplateDto(Template template) {
		this.id = template.id;
		this.text = template.text;
	}
}
