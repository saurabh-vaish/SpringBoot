package com.example.service.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.example.service.INotificationService;


@Component
@Profile("htc")    // accessible only for htc profile
public class HTCNotifactionServiceImpl implements INotificationService {

	@Override
	public void notificate() {
		
		System.out.println("only for htc profile");
	}

}
