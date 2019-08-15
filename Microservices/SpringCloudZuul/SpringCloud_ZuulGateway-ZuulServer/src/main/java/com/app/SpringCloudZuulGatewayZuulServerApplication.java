package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

/**
 *  Zuul --> Zuul gateway works as one entry and one exit point for requests . 
 *  		It works as a server for clients and consumer for eureka server. so it works as both client and server
 *  
 *  	--> It commuicates with eureka server with service id of provider and get service registery details then based in load balance 
 *  		registery it use one instance .
 *  
 *  	--> Instead of communicating with multiple microservices client communicates with zuul only .
 * 
 * 
 * **/


@SpringBootApplication
//@EnableCircuitBreaker
//@EnableHystrix
//@EnableZuulServer
//@EnableLoadTimeWeaving
// all these not need all are inside @EnableZuulProxy
@EnableZuulProxy  					/// to enable zuul serve -- internally having 
public class SpringCloudZuulGatewayZuulServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZuulGatewayZuulServerApplication.class, args);
	}

}
