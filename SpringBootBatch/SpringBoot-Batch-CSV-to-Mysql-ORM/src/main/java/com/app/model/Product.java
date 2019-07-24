package com.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="product_batch")
public class Product {

	@Id
	private Integer id;
	private String code;
	private Double cost;
	
	private Double discount;
	private Double gst;

	
}
