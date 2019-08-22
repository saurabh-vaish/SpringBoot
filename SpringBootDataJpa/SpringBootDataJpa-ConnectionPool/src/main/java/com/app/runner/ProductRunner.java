package com.app.runner;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.repo.ProductRepository;

/****
 * Pool :- A pool is collection of similer type of class objects e.g. Admin pool , Employee Pool 
 * Connection Pool :- this is used to perform application performance by reducing application time
 * 					 e.g. Tomcat Connection Pool , Hikari Connection Pool
 *  
 * Spring Boot 1.x --- Tomcat CP  (Default)
 * Spring Boot 2.x --- Hikari CP (Default)
 * 
 * Hikari CP :- It is faster than any other CP , and by default in Spring Boot 2.x 
 * 				If we not provide any configuration then spring boot provides default values using "HikariConfig" class
 * 
 *  DataSource (I)  --- HikariDataSource (Implementation class)
 *  
 */


@Component
public class ProductRunner implements CommandLineRunner {

	@Autowired
	private ProductRepository repo;
	
	@Autowired
	private DataSource ds;	
	
	@Override
	public void run(String... args) throws Exception {

		System.out.println(ds.getClass().getName());    /// com.zaxxer.hikari.HikariDataSource
		
		
		
	}

}
