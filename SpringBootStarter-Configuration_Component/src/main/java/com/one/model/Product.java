package com.one.model;

import org.springframework.stereotype.Component;

@Component
public class Product {

	private Integer prdId;

	
	
	public Integer getPrdId() {
		return prdId;
	}



	public void setPrdId(Integer prdId) {
		this.prdId = prdId;
	}



	@Override
	public String toString() {
		return "Product [prdId=" + prdId + "]";
	}
	
	
	
	
	
}
