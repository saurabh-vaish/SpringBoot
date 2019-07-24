package com.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// class to hold data for csv

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	private Integer id;
	private String code;
	private Double cost;
	
}
