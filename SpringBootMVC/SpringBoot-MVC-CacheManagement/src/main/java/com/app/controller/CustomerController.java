package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.model.Customer;
import com.app.service.ICustomerService;
import com.app.validator.CustomerValidator;


@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private ICustomerService service;
	
	@Autowired
	private CustomerValidator validator;
	
	
	@RequestMapping("/reg")
	public String showReg(Model map) {

		map.addAttribute("customer", new Customer());
	
		return "Register";
	}
	
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveData( @ModelAttribute Customer customer,Errors errors,RedirectAttributes attr)
	{
		
		validator.validate(customer, errors);
		
		if(errors.hasErrors())
		{
			attr.addFlashAttribute("errors",errors);
			attr.addFlashAttribute("customer",customer); System.out.println("error occur");
		//	return "Register";
		}
		else
		{
			
			Integer id=service.saveCustomer(customer);
			attr.addFlashAttribute("message", "customer '"+id+"' created");
		}
		
		return "redirect:reg";
		
	}
	
	
	//3. Display all records in DB at UI
	@RequestMapping("/all")
	public String showAll(Model map)
	{
		List<Customer> cobs=service.getAllCustomers();

		map.addAttribute("list", cobs);
		
		return "Data";
	}
	
	
	//4. fetch data based on id and display
	@RequestMapping("/view/{id}")
	public String viewOne( @PathVariable Integer id, Model map) 
	{
		
		Customer c=service.getOneCustomer(id);
		
		map.addAttribute("ob", c);
		
		return "View";
	}
	
	
	
	//5. delete row based on Id
	@RequestMapping("/delete/{id}")
	public String deleteOne( @PathVariable Integer id, RedirectAttributes map) 
	{
		service.deleteCustomer(id);
		
		map.addFlashAttribute("message", "Customer '"+id+"' deleted");
		
		return "redirect:/customer/all";
	}
	
	
	
	//6. Edit page
	@RequestMapping("/edit/{id}")
	public String getEdit( @PathVariable Integer id, Model map) 
	{
		
		map.addAttribute("customer", service.getOneCustomer(id));
		map.addAttribute("update",true);
		
		return "Update";
	}
	
	
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateData( @ModelAttribute Customer customer,Errors errors,Model attr)
	{
		
		validator.validate(customer, errors);
		
		if(errors.hasErrors())
		{
			attr.addAttribute("customer",customer);
			return "Update";
		}
		else
		{
			
		//	Integer id=service.updateCustomer(customer,customer.getCustId());
			Customer c=service.updateCust(customer.getCustId(),customer);
		//	attr.addAttribute("message", "customer '"+id+"' updated");
			attr.addAttribute("message", "customer  updated");
			
			return "redirect:/customer/all";
		}
		
		
	}
	
	
}



