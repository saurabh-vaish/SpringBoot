package com.app.runner;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.app.model.Product;
import com.app.repo.ProductRepository;

/****
 * we can use findBy() methods that returns  pagenation with stream enabled
 * 
 *  Streamable<T> --> Slice<T> ---> Page<T>
 *
 * these all are interfaces having different methods 
 *  
 *  Streamable <T> -- for stream methods 
 *  Slice<T> -->  for pagination related methods 
 *  Page<T> --> extra methods including above all
 *  
 *  To use pagenation we should provide Pageable interface as last parameter in methods 
 *  
 *  Pageable (I) ---> PageRequest(c) 
 */


@Component
public class ProductRunner implements CommandLineRunner {

	@Autowired
	private ProductRepository repo;
	
	@Override
	public void run(String... args) throws Exception {

		
		
		String code = repo.getProdCode(3);   // it could produce null pointer exception
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
		
		
		/*** pagenation ****/
		
		Page<Product> page = repo.findByProdCostLessThan(5.8, PageRequest.of(0,3));  /// implementation class of Pageable
		
		System.out.println(page.isEmpty());
		System.out.println(page.isFirst());
		System.out.println(page.isLast());
		System.out.println(page.getSize());
		System.out.println(page.getTotalElements());
		System.out.println(page.getTotalPages());
		System.out.println(page.getNumber());
		System.out.println(page.hasNext());
		System.out.println(page.hasPrevious());
		
		
		page.stream()                       // read data  into stream
		.filter(p->p.getProdModel()!=null)  // filter data
		.sorted((p1,p2)->p2.getProdId()-p1.getProdId())   // sorting
		.map(p->p.getProdId()+" , "+p.getProdCode()+" , "+p.getProdModel()+" , "+p.getProdCost())   //  mapping
		.forEach(System.out::println);   // printing
		
		
	}

}
