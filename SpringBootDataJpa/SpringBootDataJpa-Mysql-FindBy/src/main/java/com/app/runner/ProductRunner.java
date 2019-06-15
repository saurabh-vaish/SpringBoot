package com.app.runner;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.repo.ProductRepository;

//findBy methods - these methods are used to select columns and rows based on some condition , applicable on select statement
//these are abstract methods , code provided at run time

//format -- 
/*
	RT findBy[<variable><operator>](DT variables) ;
	
*/


@Component
public class ProductRunner implements CommandLineRunner {

	@Autowired
	private ProductRepository repo;
	
	@Override
	public void run(String... args) throws Exception {

		repo.findByProdCode("A")   			// select * from product where prodcode=?
		.forEach(System.out::println);
		
		
		repo.findByProdCostLessThan(5.5)   // .... where pcost< ?
		.forEach(System.out::println);
		
		
		repo.findByProdCodeOrProdCostGreaterThan("A", 5.5)  //	 .... where pcode=? or pcost> ?
		.forEach(System.out::println);
		
		
		repo.findByProdCodeIsNotNull()  // .... where pcode is ont null
		.forEach(System.out::println);
				
		
		repo.findByProdCodeLike("%A%")  // .... where pcode is like '%A%'"
		.forEach(System.out::println);

		repo.findByProdCostBetween(3.3, 5.5) // .... where pcost between ? and ?
		.forEach(System.out::println);

		
		repo.findByProdCodeIn(Arrays.asList("A","F","W"))  // .... where pcode in (....)
		.forEach(System.out::println);
		
		
		repo.findByProdCostOrderByProdCodeDesc(3.3)  //.... where pcost= ? order by pcode
		.forEach(System.out::println);
		
		repo.findByProdCodeLikeAndProdIdBetween("%A%", 2,8)   // ... where pcode like "%A%" and pid between ? and ?
		.forEach(System.out::println);
				
		
	}

}
