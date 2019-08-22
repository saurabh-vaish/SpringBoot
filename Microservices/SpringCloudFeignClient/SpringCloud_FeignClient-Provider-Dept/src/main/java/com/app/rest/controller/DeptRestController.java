package com.app.rest.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Dept;



@RestController
@RequestMapping("/dept")
public class DeptRestController {

	@Value("${server.port}")
	private String port;
	
	@GetMapping("/show")
	public String show()
	{
		return "From Dept provider :"+port;
	}
	
	
	@GetMapping("/get")
	public Dept getDept()
	{
		return new Dept(101,"AA","DEV");
	}
	
	
	@GetMapping("/all")
	public List<Dept> getAll()
	{
		return Arrays.asList(
				new Dept(101,"AA","DEV"),
				new Dept(102,"AB","QA"),
				new Dept(103,"AC","DEV")				
				);
	}
	
	
	@PostMapping("/save")
	public String save(@RequestParam String msg)
	{
		return "saved successfully"+msg;
	}
	
	
}
