package com.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Product;

/*
 Projections:- Projection are used to select required columns . They are of two types

1. Static Projection :- Provide always fixed columns
2.  Dynamic Projections :- No. of columns changes on every different run 

 -> to achieve projection we use interface inside repository . 
 
 Step-1 : write an interface 
 step-2 : copy getter methods from model class of those variable which need to displayed as column
 step-3 : Write getter method as abstract method and provide interface name as return type in findBy... method

*/
public interface ProductRepository extends JpaRepository<Product, Integer> {

	interface MyView{
		
		String getProdCode();
		String getProdModel();
	}
	
	interface MyData{
		
		Integer getProdId();
		Double getProdCost();
	}
	
	
	// static projection
	List<MyView> findByProdId(Integer prodId);
	
	
	// Dynamic Projection using Generics
	// pattern-   <T>  DT<T> findBy.....(DT var.. , Class<T> cls);
	// T = type 
	
	<T> List<T> findByProdCost(Double prodCost,Class<T> cls);  // here interface name will come dynamically
	
	


}
