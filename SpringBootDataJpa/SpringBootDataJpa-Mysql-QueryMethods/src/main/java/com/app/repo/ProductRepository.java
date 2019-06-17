package com.app.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Product;

/****
@QueryMethods:- These methods are used to define HQL to perform multi-row and non-select operation . We use @Query("Hql") 

--> they support both select and non-select operation
--> Select operation --- Use @Query("HQL") annotation
--> Non-select operation --- Use @Query("HQL") , @Modifying ,@Transansactional annotation
 
--> write an abstract method then write annotations according to operation
--> we can use model class name without package inside query
--> use alias name in query

****/

public interface ProductRepository extends JpaRepository<Product, Integer> {

	/**** select operations ****/ 
	
	@Query("select p from com.app.model.Product p")
	public List<Product> getProductData();   // all columns return List<T>
	
	
	@Query("select p.prodCode from Product p ")  // we can also use without package
	public List<String> getProductCode();		// one column return List<DT>
	
	
	@Query("select p.prodCode, p.prodCost from Product p ")  // we can also use without package
	public List<Object[]> getProductCode_Cost();  // multiple column return List<Object[]>
	
	
	/*** passing parameter ***/
	
	// positional parameter -- use ?number ie. ?1,?2,?3...
	
	@Query("select p from Product p where p.prodId=?1 or p.prodCost<?2")
	public List<Product>  getProdInfo(Integer id,Double cost);

	
	// named parameter -- use :name ie. :abc,:pid, :pcost3...
	// use same name as parameter name as named 
	
	@Query("select p from Product p where p.prodId=:pid or p.prodCost<:pcost")
	public List<Product>  getProductInfo(Integer pid,Double pcost);
 	
	
	
	/**** non-select Operations ****/
	
	@Modifying
	@Transactional
	@Query("update Product set prodCost=:pcost where prodId=:pid")
	public int updateProduct(Double pcost, Integer pid);

	
	@Modifying
	@Transactional
	@Query("delete from Product  where prodId=:pid")
	public int deleteProduct(Integer pid);
	
	
	/// we can also use group by, order by, in , between or aggregate functions(sum,min,max) etc.. clauses in query
	
	@Query("select p from Product p where prodId in :pids order by prodCode desc")
	public List<Product> getMyData(List<Integer> pids);
	
	
	/**** special cases ****/
	
	// when we have to return only one record we can use T or DT as return type instead of List<T> 
	// but it can produce NullPointerException 
	// to prevent NPE we use Optional<T> class 
	
	@Query("select p.prodCode from Product p where prodId=:pid")
	public String getProdCode(Integer pid);   // it may produce null pointer exception
	
	
	@Query("select p.prodCode from Product p where prodId=:pid")
	public Optional<Product> getProd(Integer pid);

	
	
}
