package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Employee;
import com.app.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service;


	// show register page

	@RequestMapping("/reg")
	public String showReg(Model map)
	{
		// form baking object
		map.addAttribute("employee",new Employee());
		return "register";
	}


	// save employee
	@RequestMapping(value = "save" ,method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute Employee employee,Model map) 
	{
		Integer id =service.saveEmployee(employee);
		map.addAttribute("msg","Employee '"+id+"' added successfully");

		//clear form baking object
		map.addAttribute("employee",new Employee());
		
		return "register";
	}


	// get all employees
	@RequestMapping("/all")
	public String showEmployee(Model map)
	{
		List<Employee> list =service.getAllEmployees();
		map.addAttribute("list",list);
		return "data";
	}

	//getOne Employee for view page
	@RequestMapping("/view")
	public String getOneEmployee(@RequestParam Integer id, Model map)
	{
		Employee emp = service.getOneEmployee(id);
		if(emp!=null)
		{			
			map.addAttribute("emp",emp);
		}
		else
		{
			map.addAttribute("msg","No Employee Found");			
		}

		return "view";
	}

	// delete employee
	@RequestMapping("/delete")
	public String deleteEmployee(@RequestParam Integer id, Model map)
	{
		service.deleteEmployee(id);
		map.addAttribute("msg","Employee deleted Successfully");
		return "redirect:all";
	}

	// get Update employee
	@RequestMapping("/getUpdate")
	public String getUpdateEmployeePage(@RequestParam Integer id, Model map)
	{
		map.addAttribute("employee",service.getOneEmployee(id));
		map.addAttribute("mode","edit");
		return "register";
	}

	/*
	 * // update employee
	 * 
	 * @RequestMapping(value = "update" ,method = RequestMethod.POST) public String
	 * updateEmployee(@ModelAttribute Employee employee,Model map) { Employee emp
	 * =service.updateEmployee(employee);
	 * map.addAttribute("msg","Employee updated successfully");
	 * 
	 * //clear form baking object map.addAttribute("employee",new Employee());
	 * return "redirect:view?id="+emp.getEmpId(); }
	 */
}
