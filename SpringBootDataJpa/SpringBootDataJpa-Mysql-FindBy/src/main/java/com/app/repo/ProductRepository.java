package com.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Product;


// findBy methods - these methods are used to select columns and rows based on some condition , applicable on select statement
//  these are abstract methods , code provided at run time
//  format -- 
/*
		RT findBy[<variable><operator>](DT variables) ;
		
*/

public interface ProductRepository extends JpaRepository<Product, Integer> {

	//1. select * from product where prodcode=?
	
	List<Product> findByProdCode(String prodCode);
	// or List<Product> findByProdCodeIs(String prodCode);
	// or List<Product> findByProdCodeEquals(String prodCode);
	
	
	//2. .... where pcost< ?
	
	List<Product> findByProdCostLessThan(Double pcost);
//	List<Product> findByProdCostLessThanEquals(Double pcost);
	
	 
	//3. .... where pcode=? or pcost> ?
	List<Product> findByProdCodeOrProdCostGreaterThan(String pcode , Double pcost);
	
	
	//4. .... where pcode is ont null
	List<Product> findByProdCodeIsNotNull();
	
	
	//5. .... where pcode is like '%A%'
	List<Product> findByProdCodeLike(String pcode);
//or List<Product> findByProdCodeContaining(String pcode);
	
		
	//6. .... where pcost between ? and ?
	List<Product> findByProdCostBetween(Double pcost1,Double pcost2);

	
	//7. .... where pcode in (....)
	List<Product> findByProdCodeIn(List<String> pcodes);


	//8. .... where pcost= ? order by pcode
//	List<Product> findByProdCostOrderByProdCode(Double pcost);   // default order is assending  order
	List<Product> findByProdCostOrderByProdCodeDesc(Double pcost);   //  in desending order


	
	


}
