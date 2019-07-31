package com.app.consumer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *  For Consumer we use RestTemplate (c) . It makes Http class from consumer  to producer and get response as responseEntity.
 *  
 *  with the help of getForEntity(url,response class) we get ResponseEntity which has Body<T> and HttpStatus(E)
 * 
 * 
 * 
 * */



@Component
public class ConsumerRunner implements CommandLineRunner {


	@Override
	public void run(String... args) throws Exception {
		
			String url="http://localhost:8080/emp/getEntity";   /// url of producer location
			
			RestTemplate rt = new RestTemplate();
			
			ResponseEntity<String> resp = rt.getForEntity(url, String.class);
			
			System.out.println(resp.getBody());
			System.out.println(resp.getStatusCode());
			System.out.println(resp.getStatusCode().name());
			
		
	}
}
