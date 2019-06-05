package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.one.model.Customer;
import com.one.model.Product;

@Configuration
public class AppConfig2 {

	
	@Bean
	public Customer cust()
	{
		System.out.println("AppConfig2 called");
		Customer c = new Customer();
		c.setCustId(5555);
		return c;
	}

	
}
