package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer					// enable eureka server
public class SpringCloudFeignClientEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFeignClientEurekaServerApplication.class, args);
	}

}
