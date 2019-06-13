package com.app.runner;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.app.model.Product;
import com.app.repo.ProductRepository;

@Component
public class ProductRunner implements CommandLineRunner {

	@Autowired
	private ProductRepository repo;
	
	@Override
	public void run(String... args) throws Exception {

		// 1. findAll() - gets all rows into List<T>
		
		repo.findAll().forEach(System.out::println);
		
		
		//2. findAll(Sort) :- sorts the results in asc or dsc order using Sort class
		 //by() - it is static factory method of Sort
		// sql: select * from product order by prodCode asc;
		
		repo.findAll(Sort.by("prodCode"))  // defult order is asc , no need to mention
		.forEach(System.out::println);
		
		
		repo.findAll(Sort.by(Direction.DESC,"prodCode"))   // for giving order Direction enum is used 
		.forEach(System.out::println);
		
		
		//3. findAll(Pageable) // gets records according to pagenation 
		// specfing pagenum and page size 
		PageRequest p = PageRequest.of(2, 3);  // static factory method 
		repo.findAll(p)
		.forEach(System.out::println);
		
		
		// 4. findAll(Example) :-  find all rows based on some Example model clas object that compare non null values in rows
		Product pd = new Product();
		pd.setProdCost(3.3);
		
		
		Example<Product> ex= Example.of(pd);
		repo.findAll(ex)
		.forEach(System.out::println);
		
		
		// Example with sorting
		repo.findAll(ex,Sort.by(Direction.DESC,"prodCode"))
		.forEach(System.out::println);
		

		// Example with pagination
		PageRequest p2 = PageRequest.of(1, 2);  
		repo.findAll(ex,p2)
		.forEach(System.out::println);
		
		
		//5.  findAllById(Ids) :- find all rows according to given ids
		// sql: select * from product where prodId in (2,4,7,11)
		repo.findAllById(Arrays.asList(2,4,7,11))
		.forEach(System.out::println);
		
	}

}
