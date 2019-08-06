package com.app.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * 	Product------<> Model
 * 
 * 	** to access model from product , create a modelconsumer inside product which will communicate with model
 * 
 * 		
 * 		ProductRestController -----<> ModelConsumer   (httpReq)=====(httpResp)  ModelProdducerRestController
 * 
 * 
 * 
 * 
 * **/


@RestController
@RequestMapping("/product")
public class ProductRestController {

	
	@Autowired
	private ModelConsumerRestController model;
	
	
	@GetMapping("/get")
	public String show()
	{
		return model.get();
	}
	
	
	@GetMapping("/getOne")
	public String showOne()
	{
		return model.getOne();
	}
	
	
	@GetMapping("/getAll")
	public String showAll()
	{
		return model.getAll();
	}
	
	
}
