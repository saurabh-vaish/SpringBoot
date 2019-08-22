package com.app.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.document.Product;

public interface ProductRepository extends MongoRepository<Product,String> {

}
