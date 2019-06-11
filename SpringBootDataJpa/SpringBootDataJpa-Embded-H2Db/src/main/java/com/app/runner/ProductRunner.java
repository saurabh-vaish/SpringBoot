package com.app.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.model.Product;
import com.app.repository.ProductRepository;

// here implementation class of ProductRepository (I) will be created at runtime and its object also
// Proxy - the class which is created at runtime and its object also and destroy at runtime only , no .class file created 


@Component
public class ProductRunner implements CommandLineRunner {

	@Autowired
	private ProductRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
			
		System.out.println(repo.getClass().getName());   // o/p -  com.sun.proxy.$Proxy78
		
		Product p =	repo.save(new Product("abc",2.2));
		System.out.println(p.getProdId());
		
		repo.save(new Product("xy",3.3));
		repo.save(new Product("pqr",4.4));
	}

}
