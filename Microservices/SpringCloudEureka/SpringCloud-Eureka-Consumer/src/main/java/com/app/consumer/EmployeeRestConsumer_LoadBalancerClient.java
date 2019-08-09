package com.app.consumer;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
 * **/




@RestController
@RequestMapping("/empLoadBalancer")
public class EmployeeRestConsumer_LoadBalancerClient {
	
	
	@Autowired
	private LoadBalancerClient client;
	
	
	@RequestMapping("/get")
	public String show()
	{
		// getting serice instance using service id
		ServiceInstance si = client.choose("EMPLOYEE-PRODUCER"); // choose method of RibbonLoadBalancerClient(C) impl class of LoadBalancerClient
		
		// getting service uri 
		URI uri = si.getUri();
		
		// constructing url from uri
		String url = uri+"/emp/get";
	
		// making http reuest
		RestTemplate rt = new RestTemplate();
		
		ResponseEntity<String> resp= rt.getForEntity(url,String.class);
		
		return resp.getBody();

	}
	
	
	
	
	@RequestMapping("/disp")
	public String showShort()
	{
		return new RestTemplate()
				.getForEntity(
						client.choose("EMPLOYEE-PRODUCER").getUri()+"/emp/get"  ,  String.class
						)
				.getBody();
	}
	
	
}
