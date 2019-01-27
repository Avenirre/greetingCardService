package com.gc.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class CardDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String congratulator;
	private String text;
	private String signature;
	
	public CardDto() {}

	public CardDto(TemplateDto templateDto) {
		this.text = templateDto.getText();
	}
}
