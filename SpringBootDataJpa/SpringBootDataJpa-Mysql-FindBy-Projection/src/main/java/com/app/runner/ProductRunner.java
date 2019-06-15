package com.app.runner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.repo.ProductRepository;
import com.app.repo.ProductRepository.MyData;

/*
Projections:- Projection are used to select required columns . They are of two types

1. Static Projection :- Provide always fixed columns
2.  Dynamic Projections :- No. of columns changes on every different run 

-> to achieve projection we use interface inside repository . 

Step-1 : write an interface 
step-2 : copy getter methods from model class of those variable which need to displayed as column
step-3 : Write getter method as abstract method and provide interface name as return type in findBy... method

*/


@Component
public class ProductRunner implements CommandLineRunner {

	@Autowired
	private ProductRepository repo;
	
	@Override
	public void run(String... args) throws Exception {

		// static projection
		repo.findByProdId(3)   			// select prodCode,prodId from product where prodId=?
		.forEach(p->System.out.println(p.getProdCode() +", "+ p.getProdModel()));
		
		
		// Dynamic Projection
		repo.findByProdCost(3.3, MyData.class) // here we change interface name then it will dynamically call from repository
		.forEach(p->System.out.println(p.getProdId() +", "+ p.getProdCost()));
		
		
				
		
	}

}
