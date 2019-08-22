package com.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="prod_tab")
public class Product {

	@Id
	private Integer prodId;
	private String prodCode;
	private String prodModel;
	private String prodVendor;	
	private Double prodCost;
	
}
