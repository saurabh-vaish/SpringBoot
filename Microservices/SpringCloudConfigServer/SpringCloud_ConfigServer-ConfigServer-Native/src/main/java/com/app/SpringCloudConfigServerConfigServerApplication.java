package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 *   Client will not communicate with external config file directly it will take help of config server i.e. this app.
 *   
 *   We can declare external properties in two ways --> 1. Native [inside folder system or project]   2. Internet [Github]  
 *   
 *   this app is example of native and external file is placed inside the server , so using classpath we can fetch
 *   
 *   config server will fetch keys from external files and give back to config client 
 *   
 *   dependency - config-server , 
 *   
 *   see properties file .
 * 
 * **/



@SpringBootApplication
@EnableConfigServer							// to enable config serer
public class SpringCloudConfigServerConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigServerConfigServerApplication.class, args);
	}

}
