package com.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Employee;

/**
 *  @ResponseBody ---> Convert Java Object to Global Data
 *  
 *  @RequestBody ---> Global to Java Object
 * 
 * 	***Internally every response type is " ResponseEntity<..>
 * 
 * ** Now in spring boot xml support using jaxB is not , we have to manually add JaxB dependency . By default it will only return JSON 
 * 
 * 
 * 	@RequestHeader ---> to get http Request header keys e.g.    @RequestHeader  DataType varName
 * 
 * 	
 * 	@RequestBody   --->   To get Http Request Body data   -- > @RequestBody  ObjectName obj 
 * 
 * 
 *  *** accept -- application/json   --> when recieving data
 *
 *  *** content-type -- application/json   --> when sending data
 * 
 *   *** 415 unsupported media   ------> sending different data format i.e. sending xml in place of json i.e. content-type not matching
 * 
 * */


@RestController								// internally contains @Controller + @ResponseBody
@RequestMapping("/emp")
public class EmployeeController {

	// get 
	
	@GetMapping("/get")
	public String showGet()
	{
		return "from get";
	}

	
	// get with entity i.e. body with http status
	
	@GetMapping("/getEntity")
	public ResponseEntity<String> showGetEntity()
	{
		return new ResponseEntity<String>("from get Entity",HttpStatus.OK);
	}
	
	
	// NO_CONTENT status will not give any body only status . So it can work like head  method
	
	@GetMapping("/head")
	public ResponseEntity<String> showGetAsHead()
	{
		return new ResponseEntity<String>("from get like Head",HttpStatus.NO_CONTENT);
	}
	
	
	// get returning list of objects 
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> showEmps()
	{
		return new ResponseEntity<List<Employee>>(Arrays.asList(
																new Employee(11,"ab"),
																new Employee(12,"cc"))
													,HttpStatus.OK);
	}
	
	
	// post
	
	@PostMapping("/post")
	public ResponseEntity<String> post()
	{
		return new ResponseEntity<String>("from post",HttpStatus.OK);
	}
	
	
	// post returning object
	
	@PostMapping("/postObject")
	public ResponseEntity<Employee> postObject()
	{
		return new ResponseEntity<Employee>(new Employee(10,"AA"),HttpStatus.OK);
	}
	
	
	// read request header param
	
	@PostMapping("/requestHeader")
	public String showHeader(@RequestHeader("sample") String key)
	{
		return "from header keys "+key;
	}

	
	// read request header param
	
	@PostMapping("/requestBody")
	public String showBody(@RequestBody Employee employee)
	{
		return "from header body "+employee;
	}
	
	
	// put --: for updating whole data
	
	@PutMapping("/put")
	public String showPut()
	{
		return "from put";
	}

	
	// patch --: for updating small changes
	
	@PatchMapping("/patch")
	public String showPatch()
	{
		return "from Patch";
	}
	
	
	// delete 
	
	@DeleteMapping("/delete")
	public String showDelete()
	{
		return "From delete";
	}
	
	
}
