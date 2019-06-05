package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.one.model.Customer;
import com.one.model.Product;

@SpringBootApplication

// springBoot can auto Detect configuration classes having annotation @Configuration
// here we dont need to pass configuration class to AC 
// as new ACAC(appconfig.class)
// here it is done automatically as they are auto loaded

public class SpringBootStarterAutoLoadConfigrationClass
{
	
	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootStarterAutoLoadConfigrationClass.class, args);
		  
	}

}
