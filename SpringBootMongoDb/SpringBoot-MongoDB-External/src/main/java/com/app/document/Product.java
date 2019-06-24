package com.app.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *   @Document ---- for mongo db . It is optional but it is good practice to use it
 *	 @Id  ----  it is also optional in case of mongo db but the varibale name should be id only , if we are using any other name 
 *				then it is recammonded to use it 
 *
 * 		for Primary Key we use always taks String as Mango use UUID for Id which is in hexadecimal form
 * 		So if we will use any other database then it will give InvalidDataAccessApiUsagesException
 */




@Document					// optional
public class Product {

	@Id					// optional
	private String id;   // must be string 
	
	private Integer prodId;
	private String prodCode;
	private Double prodCost;
	
	public Product() {
		super();
	}

	public Product(Integer prodId, String prodCode, Double prodCost) {
		super();
		this.prodId = prodId;
		this.prodCode = prodCode;
		this.prodCost = prodCost;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public String getProdCode() {
		return prodCode;
	}

	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}

	public Double getProdCost() {
		return prodCost;
	}

	public void setProdCost(Double prodCost) {
		this.prodCost = prodCost;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", prodId=" + prodId + ", prodCode=" + prodCode + ", prodCost=" + prodCost + "]";
	}
	
	
	
	
	
}
