package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudConfigServerEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigServerEurekaServerApplication.class, args);
	}

}
