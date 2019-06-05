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

// starter class is itself @Component and @Configuration i.e.
// its object is created by container so that we can also call instance methods
// it is also works as Configuration class so we can configure other beans also

public class SpringBootConfigurationAndComponent implements CommandLineRunner  // bcs @Component already present
{
	// getting object from spring container
	
	@Autowired
	private Product p;
	
	@Autowired
	private Customer c;
		
	
	// configuring beans
	
	@Bean
	public Product prj()
	{
		Product p = new Product();
		p.setPrdId(10);
		return p;
	}

	@Bean
	public Customer cust()
	{
		Customer c = new Customer();
		c.setCustId(5555);
		return c;
	}
	
	// CLR run()
	
	@Override
	public void run(String... args) throws Exception {   // instance method called as starter class object is created by container

		System.out.println(p);
		System.out.println(c);
	}
	
	public static void main(String[] args) {
		
		SpringApplication sp = new SpringApplication(SpringBootConfigurationAndComponent.class);
		ConfigurableApplicationContext ac = sp.run(args);
		
		  
	}

}
