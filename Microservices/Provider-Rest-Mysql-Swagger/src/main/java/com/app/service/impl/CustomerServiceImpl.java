package com.app.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.exception.CustomerNotFoundException;
import com.app.model.Customer;
import com.app.repo.CustomerRepository;
import com.app.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {


	@Autowired
	private CustomerRepository repo;
	
	
	@Transactional
	public Integer saveCustomer(Customer c) {
		return repo.save(c).getCid();
	}

	
	@Transactional
	public Integer updateCustomer(Customer c) {
		return repo.save(c).getCid();
	}
	
	
	@Transactional(readOnly = true)
	public boolean isPresent(Integer id)
	{
		return repo.existsById(id);
	}

	
	@Transactional(readOnly = true)
	public Customer getCustomer(Integer cid) {
		Optional<Customer> s= repo.findById(cid);
		if(s.isPresent()) {
			return s.get();
		}
		else throw new CustomerNotFoundException("No Customer Found With Given Id");
	}

	
	@Transactional
	public void deleteCustomer(Integer cid) {
		try {
			repo.deleteById(cid);
		}
		catch(Exception e)
		{
			throw new CustomerNotFoundException("No Customer Found With Given Id");
		}
	}

	
	@Transactional(readOnly = true)
	public List<Customer> getAll() {
		List<Customer> list = repo.findAll();
		
		
		if(list!=null && !list.isEmpty())
		{
				// sorting Customer based on names  using collections
				/* 
				Collections.sort(list,new Comparator<Customer>() {
					@Override
					public int compare(Customer c1, Customer c2) {
						return c1.getCname().compareTo(c2.getCname());
					}
				});
				
				*/
						
				// using streams
				return list.stream()
						.sorted((c1,c2)->c1.getCname().compareTo(c2.getCname()))	// sorting based on names in asc
						.collect(Collectors.toList());								// collect as list from stream
		}
		else return list;
	}

}
