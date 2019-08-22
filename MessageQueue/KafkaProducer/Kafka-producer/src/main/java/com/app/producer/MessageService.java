package com.app.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 *  This class will be used to send message to kafka clustor .
 *  
 *  KaktaTemplate<K,V> :-  It has method send(topicName,Message) which sends message . It sends data in form of key, value
 *  					   K = topic name data type [destination]
 *  					   V = Data type of message 
 * 
 * 	**** In Kafka we have only one memory - topic 
 * 
 * 	--- here message is coming dynamically from controller taken by user
 * 
 * */


@Component
public class MessageService {

	@Autowired
	private KafkaTemplate<String, String> kt;
	
	@Value("${my-topic-name}")
	private String topic;					// taking topic name from properties file
	
	public void sendMessage(String msg)
	{
		kt.send(topic, msg);
		
		System.out.println("message send from producer");
	}
	
}
