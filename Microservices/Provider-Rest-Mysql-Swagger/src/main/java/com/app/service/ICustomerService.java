package com.app.service;

import java.util.List;

import com.app.model.Customer;

public interface ICustomerService {

	public Integer saveCustomer(Customer customer);

	public Integer updateCustomer(Customer customer);
	
	public Customer getCustomer(Integer cid);

	public void deleteCustomer(Integer cid);
	
	public List<Customer> getAll();

}
