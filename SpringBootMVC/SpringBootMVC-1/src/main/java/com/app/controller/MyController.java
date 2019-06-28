package com.app.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/my")
public class MyController {
	
	/**
	 * Sending data from controller to ui is called data rendering .
	 * Here Model(I) , ModelMap(C)   are used for data rendering , store data in key value format
	 * ModelMap(C) -- introduced in spring 2.0 . It is on demand memory creation  .
	 * Model(I) -->intoduced in spring 2.5,  similer to modelmap , it removes unused memory i.e. unused key-value pairs  
	 */
	
	

	@RequestMapping("/show")
	public String show(Model m)
	{
		m.addAttribute("msg","welcome to app: "+new  Date());
		return "home";
	}
	
	@RequestMapping("/display")
	public String display(ModelMap map)
	{
		map.addAttribute("msg","hello from app");
		return "home";
	}
}
