package com.app.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.StudentNotFoundException;
import com.app.model.Student;
import com.app.service.IStudentService;

/**
 *  Http Status Codes --: 
 *  
 *  		1xxx  ---> Information
 *  
 *  		200 (OK)  --> Success
 *  	
 *  		204 ( NO_CONTENT) --> Requested Executed Successfully but not output given i.e. No Response Body
 *  
 *  		3xx ---> redirect
 *  
 *  		400 (BAD_REQUEST) -->  Content-type xml , sending json 
 *  
 *  		401 (UNAUTHORIZED) -->  Not a valid role 
 *  
 *   		403 (FORBIDDEN)   ---> 
 *   
 *   		404 (NOT_FOUND)  --> method not found , wrong name or path
 *   
 *   		405 (METHOD_NOT_ALLOWED)  -->   Sending get request but method is post .
 *   
 *   		406 (NOT_ACCEPTABLE)   ---> client acceptance different , provider seding different data . e.g. client required json provider sending xml
 *   
 *   		415 (UNSUPPORTED_MEDIA_TYPE)   ---> provider accepting different , client content type different .i.e. cilent sending json proider required xml
 *  
 * 			5xxx ---> Server side error
 * 
 * 		****produces == use produces in mapping to force to send only json or xml e.g. produces={"application/xml"}   ,then only xml will send not json
 *
 * 		****consumes == use comsumes in mapping to force to accept only json or xml e.g. consumes={"application/json"}   ,then only json will accpet not xml
 * 
 * **/


@RestController
@RequestMapping("/rest/student")
public class StudentController {

	
	@Autowired
	private IStudentService service;
	
	
	// save student
	
	@PostMapping("/save")
	public ResponseEntity<String> saveStudent(@RequestBody Student s)
	{
		service.saveStudent(s);
		return new ResponseEntity<String>("Student registred successfully",HttpStatus.OK);
	}
	
	
	// save student

	@PostMapping("/saveAll")
	public ResponseEntity<String> saveAllStudent(@RequestBody List<Student> s)
	{
		List<Student> list =service.saveAllStudent(s);
		
		if(list!=null && !list.isEmpty())
		{
			return  new ResponseEntity<String>("All Students registred successfully",HttpStatus.OK);
		}
		else
		{
			return  new ResponseEntity<String>("Some Problem Occured , Check students Data",HttpStatus.BAD_REQUEST);
		}
		
	}


	// update student
	
	@PutMapping("/update")
	public ResponseEntity<String> updateStudent(@RequestBody Student s)
	{
		boolean present = service.isPresent(s.getSid());
		if(present)
		{
			service.updateStudent(s);
			return new ResponseEntity<String>("Student updated successfully",HttpStatus.OK);
		}
		else throw new StudentNotFoundException("No Student Found");
	}
	
	
	// get student
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable Integer id)
	{
			Student s=	service.getStudent(id);
			return new ResponseEntity<Student>(s,HttpStatus.OK);		
		
	}
	
	
	// get all students
	
//	@GetMapping(value="/all",produces= {"applicaton/json"})					// to force to send only xml
	@GetMapping("/all")					// to force to send only xml
	public ResponseEntity<?> getAllStudents()
	{
		ResponseEntity<?> resp=null;
		
		List<Student> list = service.getAll();
		
		if(list!=null && !list.isEmpty())
		{
			resp = new ResponseEntity<List<Student>>(list,HttpStatus.OK);
		}
		else
		{
			resp = new ResponseEntity<String>("No Data Found",HttpStatus.OK);
		}

		return resp;
		
	}
	
	
	// delete Student
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer id)
	{
		service.deleteStudent(id);
		return new ResponseEntity<String>("student deleted successfully",HttpStatus.OK);
	}
	
	
	
}
