package com.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *  
 *  Parametes ---> There are 4 types of parameters in web services =
 *  				1. Request Parameters / QueryParams
 *  				2. Path Params / Path Variable
 *  				3. Header Param (Request Header)
 *  				4. Matrix Parameters 
 *  
 *  	*** Every parameters comes as String. can change to other formats 
 *  
 *  
 *  1.  Request Parameters -->  Send data in key=value format , **** order is not necessary .Also called Query Parameters
 *  							Format --  /url? key=val & key=val....
 *  							use - @RequestParam Datatype keyname;
 *
 *  							- ** Error 400 , if param not found
 *
 *  2. 	Path Parameters -->  	Faster than other parameters , **** order is required , They follows order
 *  							Format --  /url/ {val1} / {val2} ....
 *  							use - @PathVariable Datatype localVar;  
 *  
 *  							- ** Error 404 , if param not found , 400 is order changes
 *  
 *  
 *  3. 	Headers  Parameters -->  Send data in key=value format using Http  Request Header , header can be predefined or programmer defined
 *  							key = value in request header    like accept = application/json , sample = 10
 *  							use - @RequestHeader Datatype headerKey;  
 *  
 *  							- ** Error 400 , if param not found
 *   
 *  4.  Matrix Parameters --> 
 *  
 *  
 *  
 * */


@RestController								// internally contains @Controller + @ResponseBody
@RequestMapping("/emp")
public class EmployeeController 
{

	
	
	// Request Parametes
	
	// url = http://localhost:8080/emp/request?id=aa&name=abc
	
	@GetMapping("/request")
	public ResponseEntity<String> showRequestParam( @RequestParam Integer id, @RequestParam String name)
	{
		return new ResponseEntity<String>("request params are "+id+","+name,HttpStatus.OK);
	}
	
	
	
	// Path Parameters
	
	// url = http://localhost:8080/emp/path/10/abc/3.3
	
	@GetMapping("/path/{id}/{name}/{cost}")
	public ResponseEntity<String> showPathParam(@PathVariable Integer id,@PathVariable String name,@PathVariable Double cost)
	{
		return new ResponseEntity<String>("path params are "+id+","+name+","+cost,HttpStatus.OK);
	}
	

	
	// Header Parameters
	
	/// url = http://localhost:8080/emp/header
	
	@GetMapping("/header")
	public ResponseEntity<String> showHeaderParam(@RequestHeader Integer sample,@RequestHeader String accept)
	{
		return new ResponseEntity<String>("header params are "+sample+","+accept,HttpStatus.OK);
	}	
	
	
	// Request Parametes
	
	// url = http://localhost:8080/emp/matrix;id=10;name=abc
		
//	@GetMapping("/matrix")
//	public ResponseEntity<String> showMatrixParam(@MatrixVariable Integer id, @MatrixVariable String name)
//	{
//		return new ResponseEntity<String>("matrix params are "+id+","+name,HttpStatus.OK);
//	}
	
}
