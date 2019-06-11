package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Product;


// JpaRepostory takes two generic argument ModelClass name , Id data type
// it consist basic operation - save , update ,delete etc .. 
//bulk operation - saveAll ,findAll,deleteAll etc
// and for paging and shorting also 

// its implementation class will be created at runtime i.e. Proxy class

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
