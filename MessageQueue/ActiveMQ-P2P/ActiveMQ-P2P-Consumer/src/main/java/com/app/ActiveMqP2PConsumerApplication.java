package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms					// for jms configuration like connection to mom
public class ActiveMqP2PConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActiveMqP2PConsumerApplication.class, args);
	}

}
