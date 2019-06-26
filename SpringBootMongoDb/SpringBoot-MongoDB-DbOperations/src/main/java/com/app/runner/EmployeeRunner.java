package com.app.runner;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.app.document.Employee;
import com.app.repository.EmployeeRepository;

/**
 * Db operations --- all are same as jpa operations except save() & insert()
 * 	
 * save() ---  present in CrudRepository . It returns same object after inserting data with updated id 
 * 			    having three  cases-
 * 		case 1-    if id = null   				   	 ==> generate id then insert data into db
 * 		case 2-    if id = "123ab" (given by user)   ==>  if not present in db then insert data
 * 	  ##case 3-    if id = "123ab" (given by user)   ==>  if present in db , update that record with new one
 * 
 *  insert() --- present in MongoRepository Since Boot 1.7  It returns same object after inserting data with updated id ,
 *  			  having three cases-
 * 		case 1-    if id = null   				   	 ==> generate id then insert data into db
 * 		case 2-    if id = "123ab" (given by user)   ==>  if not present in db then insert data
 * 	  ##case 3-    if id = "123ab" (given by user)   ==>  if present in db , throws exceptio
 * */


@Component
public class EmployeeRunner implements CommandLineRunner {

	@Autowired
	private EmployeeRepository repo;

	@Override
	public void run(String... args) throws Exception {

	
		repo.deleteAll();

		//1.  save() -- id not given , auto generated , insert
		Employee e = repo.save(new Employee(10,"AA",1.1));
		System.out.println(e);

		//2. save() -- id given by user , if not exit insert
		Employee e1 = repo.save(new Employee("123ab",10,"BB",2.2));
		System.out.println(e1);

		//3. save() -- id given by user , if present , update that record with new data
		Employee e2 = repo.save(new Employee("123ab",11,"CC",3.3));
		System.out.println(e2);


		//4. findAll() -- to fetch all records 
		repo.findAll().forEach(System.out::println);   // only two bcs third is updated with 2nd


		System.out.println("------------------------------");
		
		//5.  insert() -- id not given , auto generated , insert
		Employee e3 = repo.insert(new Employee(12,"DD",4.5));
		System.out.println(e3);

		//6. insert() -- id given by user , if not exit insert
		Employee e4 = repo.insert(new Employee("678df",13,"EE",5.5));
		System.out.println(e4);

		//7. insert() -- id given by user , if present , throws Exception
		Employee e5 = repo.insert(new Employee("678df",13,"FF",6.6));
		System.out.println(e5);


		//8. findAll() -- to fetch all records 
		repo.findAll().forEach(System.out::println);   // only two bcs third will throw Exception
		
		
		//9.  sorting in desc order
		repo.findAll(Sort.by(Direction.DESC, "empSal")).forEach(System.out::println);
		
		System.out.println("------------------------------");
		
		//10. sorting in default order asc
		repo.findAll(Sort.by("empSal")).forEach(System.out::println);

		System.out.println("------------------------------");

		//11. pagination
		repo.findAll(PageRequest.of(0, 2)).forEach(System.out::println);

		System.out.println("------------------------------");
		
		Optional<Employee> data = repo.findById("678df");
		if(data.isPresent())
		{
			System.out.println(data.get());
		}
		else {
			System.out.println("no data present");
		}
		
		
		System.out.println("=============***************============");
	}

}
