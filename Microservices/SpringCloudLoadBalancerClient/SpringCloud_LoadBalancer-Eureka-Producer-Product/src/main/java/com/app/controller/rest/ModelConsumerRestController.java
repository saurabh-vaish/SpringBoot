package com.app.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



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
 *    
 *    Steps For LoadBalancerClient (I) ---->  RibbonLoadBalancerClient
 *    
 *    		 ----  Using Fetch Registery Service  we get List of Server Instances .
 *    			
 *    		--  Get one server instances based on load factor
 *    
 *     		--  Get Uri from service instance
 *     
 *     		--  Construct Url using this uri 
 *     
 *     		-- Make http request to provider using RestTemplate
 *     
 *     		-- get response from provider .
 *
 * 
 * 
 * **/





@Service				// bcs it is working to communicate to Model Producer 
public class ModelConsumerRestController {

	@Autowired
	private LoadBalancerClient client;
	
	// getting info
	public String get()
	{
		return new RestTemplate()
				.getForEntity(
						client.choose("MODEL-PRODUCER").getUri()+"/model/get" , String.class
						)
				.getBody();
	}

	
	// getting one employee 
	public String getOne()
	{
		return new RestTemplate()
				.getForEntity(
						client.choose("MODEL-PRODUCER").getUri()+"/model/getOne" , String.class
						)
				.getBody();
	}
	
	
	// getting list of employees
	public String getAll()
	{
		return new RestTemplate()
				.getForEntity(
						client.choose("MODEL-PRODUCER").getUri()+"/model/getAll" , String.class
						)
				.getBody();
	}
	
	
}
