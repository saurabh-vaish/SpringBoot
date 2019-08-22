package com.app.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


/**
 *  Circuit Breaker :- It is used to handle fault tolerance in microservices.
 *  				---It works with fallback method and circuit breaking system with APIs Hystrix and Turbine
 *  				---It avoids Improper response and  sudden termination of process.
 *  			
 *  				---When any exception came fallback method executed that gives response and alerts to dashboard etc.
 *  				
 *  				---When again & again exception comes then circuit breaker breaks the circuit and directly goes to fallback method
 *  				without going to rest method . It is called circuit is open
 * 			
 * 					-- For this we use dependency -- Hystrix , Hystrix-dashboard (for dashboard monitoring)
 * 
 * 					-- annotation @EnableCircuitBrreker or @EnableHystrix at starter class level
 * 
 * 					-- @HystrixCommand(fallbackmethod= "name") --> on rest method 
 * 
 * 			****  Rest Method and Fallback Method must be same [method name can be changed but not other]
 * 
 * 		*** to access hystrix dashboard ---http://incrediblesrv:appPort/actuator/hystrix.stream
 * 
 * ***/




@RestController
@RequestMapping("exp")
public class ExampleRestController {

	
	@GetMapping("/info")
	@HystrixCommand(fallbackMethod = "getInfoFallbackMethod")   //  fallback method name
	public String getInfo()
	{
		System.out.println("from info");
		if(new Random().nextInt(15)<=11)
		{
			throw new RuntimeException("DUMMY");
		}
		return "from info";
	}
	
	
	public String getInfoFallbackMethod()  				// must be same 
	{
		System.out.println("Inside fallback method");
		
		return "from fallback method";
	}
	
}
