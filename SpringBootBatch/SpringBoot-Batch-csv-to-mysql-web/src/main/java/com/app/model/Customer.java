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
@Table(name="customer_batch")
public class Customer {

	@Id
	private Integer id;
	private String name;
	private String city;
	
	private Double cartValue;
	private Double total;

	
}
