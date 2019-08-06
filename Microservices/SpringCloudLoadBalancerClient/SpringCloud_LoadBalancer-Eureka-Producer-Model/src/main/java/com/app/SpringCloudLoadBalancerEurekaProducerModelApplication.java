package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient									// enable eureka client
public class SpringCloudLoadBalancerEurekaProducerModelApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudLoadBalancerEurekaProducerModelApplication.class, args);
	}

}
