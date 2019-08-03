package com.app.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



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
	
	
	
	
	
	
}
