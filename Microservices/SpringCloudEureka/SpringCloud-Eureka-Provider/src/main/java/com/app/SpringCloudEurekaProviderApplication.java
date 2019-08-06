package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *  First start Eureka server 
 *  
 *  then start producer app.
 * 
 * 	To access Producer app click on application name (status tab) in instances in eureka dashboard .
 * 
 *   It will open in other tab like --http://incrediblesrv:9090/actuator/info
 *   
 *   delete actuator/info  add give rest controller path and method paths . like http://incrediblesrv:9090/emp/get
 * 	
 * 
 * ***/



@SpringBootApplication
// @EnableDiscoveryClient				// for any server , but it is slow
@EnableEurekaClient					// only for eureka server , it is fast 
public class SpringCloudEurekaProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaProviderApplication.class, args);
	}

}
