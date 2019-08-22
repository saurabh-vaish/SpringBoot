package com.app.repo;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.model.Product;

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


public interface ProductRepository extends JpaRepository<Product, Integer> {

	/**** select operations ****/ 
	
	
	/**** prevent null pointer ****/
	
	// when we have to return only one record we can use T or DT as return type instead of List<T> 
	// but it can produce NullPointerException 
	// to prevent NPE we use Optional<T> class 
	
	@Query("select p.prodCode from Product p where prodId=:pid")
	public String getProdCode(Integer pid);   // it may produce null pointer exception
	
	
	@Query("select p.prodCode from Product p where prodId=:pid")
	public Optional<Product> getProd(Integer pid);

	
	/**** Pageable with streams ****/ 
	
		
	Page<Product> findByProdCostLessThan(Double prodCost, Pageable p);
	
	
}
