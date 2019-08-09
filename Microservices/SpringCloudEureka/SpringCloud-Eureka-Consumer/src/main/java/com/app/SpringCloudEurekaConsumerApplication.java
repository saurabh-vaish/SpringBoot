package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients					// to enable feign client
@EnableEurekaClient						// to enable eureka client
public class SpringCloudEurekaConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaConsumerApplication.class, args);
	}

}
