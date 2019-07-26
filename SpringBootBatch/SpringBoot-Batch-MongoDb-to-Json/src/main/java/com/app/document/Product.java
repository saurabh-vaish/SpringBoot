package com.app.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection  = "product")
public class Product {

	@Id
	private String pid;
	
	private String prodId;
	private String prodCode;
	private Double prodCost;
	
	private Double discount;
	private Double gst;

	
}
