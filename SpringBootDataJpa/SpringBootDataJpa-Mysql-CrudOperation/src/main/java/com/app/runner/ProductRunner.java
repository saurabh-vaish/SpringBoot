package com.app.runner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.model.Product;
import com.app.repo.ProductRepository;

@Component
public class ProductRunner implements CommandLineRunner {

	@Autowired
	private ProductRepository repo;
	
	@Override
	public void run(String... args) throws Exception {

		//System.out.println(repo.getClass().getName());
		
		// 1. save operation 		
		// this save() method is work as save or update , if id exits then update or insert operation
		repo.save(new Product(10,"AA",2.2));
		repo.save(new Product(11,"BB",3.3));
		repo.save(new Product(12,"CC",4.4)); 
		repo.save(new Product(13,"DD",5.5));
		
		//2. update -- if id exit then automatically work as update operation
		repo.save(new Product(13,"EE",6.5));
		
		
		//3. saveAll() operation
		List<Product> list = Arrays.asList(
				new Product(101,"PP",7.7),
				new Product(102,"QQ",9.9),
				new Product(103,"RR",8.8)
				);
		
		
		repo.saveAll(list); // it will perform bulk operation
		
		
		// 4. findById(Id) - get one record 
		Optional<Product> p = repo.findById(12);  // Optional :- used to prevant NullPointerException
		if(p.isPresent())    // execute only if record is not null
		{
			Product prd = p.get();  // getting record
			System.out.println(prd);
		}
		else {
			System.out.println("no record found");
		}
		
		
		
		// 5. findAll() :-  get all records
		
		List<Product> prds = repo.findAll();
		prds.forEach(System.out::println);
		
		
		// 6. delete() :- delete one record
		repo.deleteById(101);
		
		
		// 7. delete all records
		// deleteAll() :-  delete all records one by one , it uses Jdbc query in loop
		// delete from <table> where id=?
		
		repo.deleteAll();
		
		
		// deleteAllInBatch() :- delete all records
		// delete from <table>
		repo.deleteAllInBatch(); 
		
		
	}

}
