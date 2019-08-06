package com.app.controller.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Employee;


@RestController
@RequestMapping("/model")
public class ModelRestController {

	
	@GetMapping("/get")
	public String show()
	{
		return "Hello from provider";
	}
	
	
	@GetMapping("/getOne")
	public Employee showOne()
	{
		return new Employee(10,"AA",3.4);
	}
	
	
	@GetMapping("/getAll")
	public List<Employee> showAll()
	{
		return Arrays.asList(
				new Employee(10,"AA",2.3),
				new Employee(11,"AB",1.3),
				new Employee(12,"AC",4.3)
				);
	}
	
	
}
