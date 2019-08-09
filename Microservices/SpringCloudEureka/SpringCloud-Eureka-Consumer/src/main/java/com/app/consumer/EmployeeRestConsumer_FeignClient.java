package com.app.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *  FeignClient or Declarative Client :-  It is a client http component helps in to communicate between consumer and provider . 
 * 						-- It is open source provided  by Netflix 
 * 
 * 						** It is works on Proxy design pattern. at runtime a class is created which implemnts client logic
 * 							and make call to provider rest controller methods and get response.
 * 						
 * 						** It also implementing load balancing with help of Ribbon 
 * 
 * 		WorkFlow --> Make an interface annotated with @FeignClient("..provider service id..") 
 * 				
 * 				** declare mathods same as rest controller controller .
 * 
 * 			--- Using serviceId it communicates with R&D server and get LBSR( load balancing service registery) .
 * 
 * 			-** At runtime a proxy class is generated which makes all the process , based on load factor it will give service instance
 * 		
 * 			-- Proxy class supports http request and response using dynamic service id.
 * 
 * 
 * 
 * **/


@FeignClient("EMPLOYEE-PRODUCER")
public interface EmployeeRestConsumer_FeignClient {

	// methods same as in EmployeeRestController
	
	@GetMapping("/emp/get")
	public String showGet();
	
	@GetMapping("/emp/getEntity")
	public ResponseEntity<String> showGetEntity();
	
	
}
