package com.app.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "product_batch")
public class Product {

	@Id
	private String pid;  // uuid for mongo db
	
	private String id;
	private String code;
	private Double cost;
	
	private Double discount;
	private Double gst;

	
}
