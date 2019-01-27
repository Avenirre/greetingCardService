package com.gc.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection="cards")
@Data
public class Card {
	
	public Card(CardDto cardDto) {
		this.congratulator = cardDto.getCongratulator();
		this.text = cardDto.getText();
		this.signature = cardDto.getSignature();
	}
	
	private String congratulator;
	private String text;
	private String signature;
}
