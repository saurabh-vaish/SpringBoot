package com.app.runner;


import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.model.Product;
import com.app.repo.ProductRepository;

/****
@QueryMethods:- These methods are used to define HQL to perform multi-row and non-select operation . We use @Query("Hql") 

--> they support both select and non-select operation
--> Select operation --- Use @Query("HQL") annotation
--> Non-select operation --- Use @Query("HQL") , @Modifying ,@Transansactional annotation
 
--> write an abstract method then write annotations according to operation
--> we can use model class name without package inside query
--> use alias name in query

****/

@Component
public class ProductRunner implements CommandLineRunner {

	@Autowired
	private ProductRepository repo;
	
	@Override
	public void run(String... args) throws Exception {

		
		repo.getProductData()
		.forEach(System.out::println);
			
		repo.getProductCode()
		.forEach(System.out::println);

		repo.getProductCode_Cost()
		.forEach(p->System.out.println(p[0]+" , "+p[1]));    // object[] printing
		
		repo.getProdInfo(2, 3.4)
		.forEach(System.out::println);  
		
		repo.getProductInfo(2, 3.4)
		.forEach(System.out::println); 

		
		int id =repo.updateProduct(22.44,3);
		System.out.println(id);

		
		int i =repo.deleteProduct(2);
		System.out.println(i);
		
		repo.getMyData(Arrays.asList(1,3,5))
		.forEach(System.out::println);
		
		
		String code = repo.getProdCode(3);
		System.out.println(code);
		
		
		// prevent null pointer exception
		Optional<Product> prd = repo.getProd(2);
		
		if(prd.isPresent())   // checks for null ,allow  only when object is not null
		{
			System.out.println(prd.get().getProdCode());   // get() return object
		}
		else {
			System.out.println("record not found");
		}
		
		
	}

}
