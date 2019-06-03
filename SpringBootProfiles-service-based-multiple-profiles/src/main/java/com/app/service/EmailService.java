package com.app.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Component
@Profile("email")
public class EmailService implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {

		System.out.println("email service");
	}
	
}
