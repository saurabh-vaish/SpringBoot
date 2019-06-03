package com.example.service.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.example.service.INotificationService;


@Component
@Profile("dml")    // accessible only for dml profile
public class DMLNotifactionServiceImpl implements INotificationService {

	@Override
	public void notificate() {
		
		System.out.println("only for dml profile");
	}

}
