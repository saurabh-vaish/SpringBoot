package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class ActiveMqPubSubConsumer1Application {

	public static void main(String[] args) {
		SpringApplication.run(ActiveMqPubSubConsumer1Application.class, args);
	}

}
