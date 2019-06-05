package com.example.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.service.INotificationService;


@Component
public class NotificationRunner implements CommandLineRunner{

	
	@Autowired
	private INotificationService service;
	
	@Override
	public void run(String... args) throws Exception {
		service.notificate();
	}
}
