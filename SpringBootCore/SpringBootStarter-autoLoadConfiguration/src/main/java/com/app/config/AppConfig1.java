package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.one.model.Customer;
import com.one.model.Product;

@Configuration
public class AppConfig1 {

	
	@Bean
	public Product prj()
	{
		System.out.println("AppConfig1 Clalled");
		Product p = new Product();
		p.setPrdId(10);
		return p;
	}

	
}
