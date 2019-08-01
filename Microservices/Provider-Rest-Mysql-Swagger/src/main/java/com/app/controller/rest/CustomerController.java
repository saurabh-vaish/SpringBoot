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

import com.app.model.Customer;
import com.app.service.ICustomerService;

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
@RequestMapping("/rest/Customer")
public class CustomerController {

	
	@Autowired
	private ICustomerService service;
	
	
	// save Customer
	
	@PostMapping("/save")
	public ResponseEntity<String> saveCustomer(@RequestBody Customer c)
	{
		Integer id =service.saveCustomer(c);
		return new ResponseEntity<String>("Customer registred successfully",HttpStatus.OK);
	}
	


	// update Customer
	
	@PutMapping("/update")
	public ResponseEntity<String> updateCustomer(@RequestBody Customer c)
	{
		service.saveCustomer(c);
		return new ResponseEntity<String>("Customer updated successfully",HttpStatus.OK);
	}
	
	
	// get Customer
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable Integer id)
	{
			Customer c=	service.getCustomer(id);
			return new ResponseEntity<Customer>(c,HttpStatus.OK);		
		
	}
	
	
	// get all Customers
	
//	@GetMapping(value="/all",produces= {"applicaton/json"})					// to force to send only xml
	@GetMapping("/all")					// to force to send only xml
	public ResponseEntity<?> getAllCustomers()
	{
		ResponseEntity<?> resp=null;
		
		List<Customer> list = service.getAll();
		
		if(list!=null && !list.isEmpty())
		{
			resp = new ResponseEntity<List<Customer>>(list,HttpStatus.OK);
		}
		else
		{
			resp = new ResponseEntity<String>("No Data Found",HttpStatus.OK);
		}

		return resp;
		
	}
	
	
	// delete Customer
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Integer id)
	{
		service.deleteCustomer(id);
		return new ResponseEntity<String>("Customer deleted successfully",HttpStatus.OK);
	}
	
	
	
}
