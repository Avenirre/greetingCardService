package com.gc.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="templates")
@Data
@NoArgsConstructor
public class Template {
	
	Long id;
	String text;
}
