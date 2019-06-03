package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// sometimes we need service based execution and execute multiple profiles then we give multiple profiles as a time
//spring.profiles.active=email,sms

@SpringBootApplication
public class SpringBootProfilesServiceBasedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProfilesServiceBasedApplication.class, args);
	}

}
