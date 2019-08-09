package com.app.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.consumer.DeptRestConsumer;
import com.app.model.Dept;

@RestController
@RequestMapping("/admin")
public class AdminRestController {

	
	@Autowired
	private DeptRestConsumer consumer;
	
	@GetMapping("/show")
	public String getMsg()
	{
		return consumer.show();
	}
	
	@GetMapping("/get")
	public Dept getOne()
	{
		return consumer.getDept();
	}
	
	
	@GetMapping("/all")
	public List<Dept> getAll()
	{
		return consumer.getAll();
	}
	
	
	@GetMapping("/save")
	public String save()
	{
		return consumer.save("hello from admin");
	}
	
	
}
