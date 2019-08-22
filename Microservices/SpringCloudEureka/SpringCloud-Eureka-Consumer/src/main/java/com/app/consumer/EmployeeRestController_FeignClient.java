package com.app.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *  ** Every client must need to add to server with server id .
 *  ** If a project is running with multiple instances then service id will be one and these instances will be instance id
 *  
 *  **  Eureka Server Registery ===  Service id  +  instance id
 * 
 * 
 *  ** Every Client fetch registery details using -- Discovery Clinet , LoadBalancing Client , Feign Client 
 *  
 *   ** Every client component need Service-Instance obj to communicate with producer application .
 *   
 *    Service-Instance -- one server instance containing --
 *    									
 *    					- Service Id ( Project Name )
 *    					- Instance Id ( Server Instance Name )
 *    					- URI  ( Host , port , etc .)
 *    					- Meta Data ( header , Cookies , Sessions ..)
 *    					- Current Load Factor
 *    
 *    In the case of FiegnClient :-  We doesn't communicate with provider directly , an interface annotated with @FeignCLient works 
 *    								 as a mediator between consumer rest controller and provider rest controller .
 *    
 *        		FeignClient does work automatically we have only to make an interface with annotation and provide method as same provider controller.
 *        
 *       ---> make has a with feign client call methods . 
 *        
 * **/




@RestController
@RequestMapping("/empFeign")	
public class EmployeeRestController_FeignClient {
	
	
	
	@Autowired
	private EmployeeRestConsumer_FeignClient client;
	
	
	@GetMapping("/get")  				// path to provider rest controller method
	public String show()
	{
		System.out.println(client.getClass().getName());
		
		return client.showGet();
	}
	
	
	
	
	@GetMapping("/disp")
	public String showShort()
	{
		return client.showGetEntity().toString(); 				// converting entity to string
	}
	
	
}
