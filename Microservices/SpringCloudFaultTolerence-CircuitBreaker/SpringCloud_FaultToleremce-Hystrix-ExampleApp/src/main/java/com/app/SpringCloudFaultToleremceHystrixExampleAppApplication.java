package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix												// for Circuit Breaker
@EnableHystrixDashboard										// for Hystrix dashboard
public class SpringCloudFaultToleremceHystrixExampleAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFaultToleremceHystrixExampleAppApplication.class, args);
	}

}
