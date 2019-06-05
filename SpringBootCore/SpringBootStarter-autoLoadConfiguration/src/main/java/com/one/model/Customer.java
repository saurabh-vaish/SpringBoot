package com.one.model;

import org.springframework.stereotype.Service;

@Service
public class Customer {

	private Integer custId;

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + "]";
	}
	
	
	
	
}
