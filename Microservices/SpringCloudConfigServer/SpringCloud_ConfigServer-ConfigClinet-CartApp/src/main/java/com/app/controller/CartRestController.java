package com.app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *  To communicate with external config file we use config client , it communicates through config server ,which fetch data from 
 *  external file [native or github] then return back to config client 
 * 
 * 	If we will update our external config file then in our app properties will not get updated .
 * 
 *  To do this we will add actuator dependency and use its service Refresh , apply annotation @RefreshScope 
 *  
 *  Whenever external file gets changed , then make a post request to "http://incrediblesrv:appPort/actuator/refresh"
 * 
 * 	then the changes will reflect on client app also 
 * 
 * */


@RestController
@RequestMapping("/cart")
@RefreshScope
public class CartRestController {

	@Value("${my.msg:default value}")	// here @Value("${key:default value}")  format is used because if key not found on server
	private String code;      			// then default will be taken it will save from exception.
	
	
	
	@GetMapping("show")
	public String show()
	{
		return "from cart "+code;
	}
	
}
