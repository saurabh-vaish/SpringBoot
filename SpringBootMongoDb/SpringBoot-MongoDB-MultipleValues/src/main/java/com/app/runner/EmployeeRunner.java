package com.app.runner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.document.Address;
import com.app.document.Employee;
import com.app.repository.EmployeeRepository;

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
public class EmployeeRunner implements CommandLineRunner {

	@Autowired
	private EmployeeRepository repo;
	
	@Override
	public void run(String... args) throws Exception {

		
	//	repo.deleteAll();
		
		Map<String,String> depts = new HashMap<>();
		depts.put("dep1", "production");
		depts.put("dep2", "development");
		
		
		repo.save(new Employee(101,"Srv",3.3,  // primitives
				new String[] {"p1","p2","p3"},  // String[]
				Arrays.asList("prj1","prj2"),  // List
				depts,  						// Map
				new Address("5/12","Hyd")		// Has-A
			)
		);
		
		System.out.println("-------------------------------------------");
		
		repo.findAll()
		.forEach(System.out::println);
		
		
	}
	
}
 
/** o/p **/
/* 
 {
        "_id" : ObjectId("5d11c08b3dc9f10614bb7570"),
        
        "empId" : 101,
        "empName" : "Srv",
        "empSal" : 3.3,

        "prjCodes" : [
                "p1",
                "p2",
                "p3"
        ],
        
        "empPrjs" : [
                "prj1",
                "prj2"
        ],
        
        "empDepts" : {
                "dep1" : "production",
                "dep2" : "development"
        },
        
        "addr" : {
                "hno" : "5/12",
                "loc" : "Hyd"
        },
        
        "_class" : "com.app.document.Employee"
}

*/
