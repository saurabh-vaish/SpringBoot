package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *  SOA - Service Oriented Architecture , three parts--- consumer , provider , R&D server 
 * 	
 * 	Resource And Discovery Server (R&D) --- used to provide the solution for the problems of load balancing and server migration. e.g. Netfilx Eureka , Zoo Keeper
 * 
 * 	Every client (consumer or producer) must register with R&D server . Server store details in the form of map(k,V)  
 * 
 * 	Every client is registered with  ServiceId (KEY) and InstanceIds(VALUE) , these values must be unique
 * 
 * 	ServiceId - It is used to find resource , generally it is the application name i.e. context path
 * 
 * 	InstanceId --- After load balancing no of instances running denote instance it they are attached with URI.
 * 
 * 
 * 	For Netfix Eureka Dependency -- Eureka Server -- spring-cloud-starter-netflix-eureka-server
 * 
 * 	@EnableEurekaServer --- enables eureka server.
 * 
 * 	Port --- 8761   Recommonded port for R&D server .
 * 
 *  To resister with R&D server i.e. eureka , use key register-with-eureka
 *  
 *  Since Every client (consumer or producer) must register with R&D server so by default it was made true
 *
 *	But here it is false as it is server itself ,so no need to register.
 *
 *	To fetch registery details from server use key fetch-registery by default it is true
 *
 *	But here it is false as server itself no need to fetch ,so false
 *
 *	In Pom.xml -- we need to define that this server app does not need to register and fetch so make keys false , rest every client needed so by default true.
 * 
 * */



@SpringBootApplication
@EnableEurekaServer				// to enable eureka server , i.e. to configure it
public class SpringCloudEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaServerApplication.class, args);
	}

}
