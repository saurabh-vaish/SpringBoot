package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient						// to enable eureka client
public class SpringCloudEurekaConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaConsumerApplication.class, args);
	}

}
