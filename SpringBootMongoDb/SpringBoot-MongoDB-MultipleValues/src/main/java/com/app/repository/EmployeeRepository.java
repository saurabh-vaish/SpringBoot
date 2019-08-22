package com.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.document.Employee;


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
 *	 @Id  ----  it is also optional in case of mongo db but the variable name should be id only , if we are using any other name 
 *				then it is recommended to use it 
 *
 * 		for Primary Key we use always take as String , bcs Mongo use UUID for Id which is in hexadecimal form
 * 
 * 		So if we will use any other database then it will give InvalidDataAccessApiUsagesException
 */





public interface EmployeeRepository extends MongoRepository<Employee,String> {

}
