package com.example.service.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.example.service.INotificationService;


@Component
@Profile("default")    // it means default profile that is common for all , the profile name default is fixed for default profile.
public class DefaultNotifactionServiceImpl implements INotificationService {

	@Override
	public void notificate() {
		
		System.out.println("default profile common for all");
	}

}
