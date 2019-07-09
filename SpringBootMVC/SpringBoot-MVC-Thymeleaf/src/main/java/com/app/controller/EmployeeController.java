package com.app.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.Employee;

@Controller
public class EmployeeController {
	
	private static final Logger logger = LogManager.getLogger(EmployeeController.class);
	
	@RequestMapping("/reg")
	public String getRegister(Model map)
	{
		logger.info("entered into register method");
		
		// form backing object
		map.addAttribute("employee",new Employee());
		
		return "register";
	}
	
	
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute Employee employee,Model map)
	{
		logger.info("entered into save method");
		
		map.addAttribute("msg","employee added successfully");
		map.addAttribute("emp","employee");
		
		logger.info("saved successfully" + employee);
		return "info";
	}
	
	
	@RequestMapping("/all")
	public String getAllEmployees(Model map)
	{
		
		List<Employee> emp = Arrays.asList(
								new Employee(10,"AA",1.1),
								new Employee(11,"BB",2.1),
								new Employee(12,"CC",3.1)
				);
		
		map.addAttribute("list",emp);
		
		logger.info("getted All employees "+emp);
		return "data";
	}
}
