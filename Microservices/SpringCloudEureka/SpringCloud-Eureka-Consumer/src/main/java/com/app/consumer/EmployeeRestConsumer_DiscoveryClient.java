package com.app.consumer;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 *  ** Every client must need to add to server with server id .
 *  ** If a project is running with multiple instances then service id will be one and these instances will be instance id
 *  
 *  **  Eureka Server Registry ===  Service id  +  instance id
 * 
 * 
 *  ** Every Client fetch registry details using -- Discovery Client , LoadBalancing Client , Feign Client 
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
 *    Steps for DiscoveryClient---
 *    			
 *    			--- Make has-A with DiscoveryClient(I)
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
@RequestMapping("/empDiscovery")
public class EmployeeRestConsumer_DiscoveryClient {

	
	@Autowired
	private DiscoveryClient client;
	
	
	@RequestMapping("/show")
	public String showMsg()
	{
		
		// get Service Instance using service id
		List<ServiceInstance> list = client.getInstances("EMPLOYEE-PRODUCER");    //serice id of producer
		
		// get one service instance
		ServiceInstance si = list.get(0);   
		
		// getting service uri
		URI uri = si.getUri();

		
		// constructing url from uri
		String url = uri+"/emp/get";
		
		
		// making http request to provider using url
		RestTemplate rt = new RestTemplate();
	
		ResponseEntity<String> resp = rt.getForEntity(url, String.class);
		
		// getting response 
		String msg = resp.getBody();
		
		return "CONSUMER" + msg;
	}
}
