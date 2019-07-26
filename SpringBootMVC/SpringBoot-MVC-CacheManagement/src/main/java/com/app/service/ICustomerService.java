package com.app.service;

import java.util.List;

import com.app.model.Customer;

public interface ICustomerService {

	public Integer saveCustomer(Customer c);
	public List<Customer> getAllCustomers();
	public Customer getOneCustomer(Integer custId);
	public void deleteCustomer(Integer custId);
	
	public Customer updateCust(Integer custId,Customer c) ;
	
}







