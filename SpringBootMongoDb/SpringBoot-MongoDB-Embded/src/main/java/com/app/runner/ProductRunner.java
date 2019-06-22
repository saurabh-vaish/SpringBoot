package com.app.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.document.Product;
import com.app.repository.ProductRepository;

/****
 * MongoDb --- MongoDB is a NoSQL db . It stores data in Collections instead of tables in the form of JSON obj
 * Here   One class (Document)  ==== One Collection
 * 		  One Object ==== One JSON Row
 * 	
 * 	MongoDB uses MongoRepository ---> PagingAndSoringRepository--->CrudRepository----> Repository
 * 
 * 	It uses methods instead of Sql 
 *  
 *  @Document --- is used in model (Document) class 
 *
 */
/**
 *   @Document ---- for mongo db . It is optional but it is good practice to use it
 *	 @Id  ----  it is also optional in case of mongo db but the varibale name should be id only , if we are using any other name 
 *				then it is recammonded to use it 
 *
 * 		for Primary Key we use always take as String as Mango use UUID for Id which is in hexadecimal form
 * 
 * 		So if we will use any other database then it will give InvalidDataAccessApiUsagesException
 */


@Component
public class ProductRunner implements CommandLineRunner {

	@Autowired
	private ProductRepository repo;
	
	@Override
	public void run(String... args) throws Exception {

		
	//	System.out.println(repo.getClass().getName());
		
		
		repo.deleteAll();
		
		repo.save(new Product(10,"A",2.2));
		repo.save(new Product(11,"B",4.2));
		repo.save(new Product(12,"C",5.2));
		
		System.out.println("-------------------------------------------");
		
		repo.findAll()
		.forEach(System.out::println);
		
		
	}
	
}
