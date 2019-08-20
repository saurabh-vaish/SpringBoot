package com.app.sender;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.app.message.MyMessage;

/**
 *  P2P :- Send Message from one producer to one consumer . It store messages in destination memory called Queue .
 * 
 * 	Produces :-  It uses JmsTemplate to send message to consumer.
 * 
 * 	JmsTemplate - Internally uses @EnableJms to make connection with mom using details given in property file. 
 * 
 * 		jt.send(destinationName , MessageCreater) is used to send message 
 * 
 * 		here destination name is the name of the memory i.e. Queue to Topic 
 * 
 * 		MessageCreater is an interface having one abstract method createMessage(Session s) , so we can use lambda .
 * 
 * 		It uses Jms Session Object to send message .
 * 
 * 		Jms Session have methods createTestMessase(String msg) ,   createObjectMessage(Serializable object)   
 * 
 * 		For sending Object , the object must be serializable .
 * 
 * 		ConnectionFactory (I) is used for connecting to MOM 
 * 
 * 		ConnectionFactory---<> ActiveMQConnectionFactory (c) 
 * 
 * 
 * **/




@Component
public class MyMessageSender implements CommandLineRunner {

	
	@Autowired
	private JmsTemplate jt;
	
	
	@Override
	public void run(String... args) throws Exception {

		// sending text message
		jt.send("my-p2p-text", s->s.createTextMessage("Hello from Producer as Test Message"));
		
		
		// sending object
		
		Map<String,Double> map = new HashMap<>();
		map.put("DEV", 1000.0);
		map.put("Prod", 1500.0);		
		
		
		MyMessage msg = new MyMessage();
		msg.setId(101);
		msg.setName("SRV");
		msg.setRoles(Arrays.asList("ADMIN","EMP"));
		msg.setDepSal(map);
		
		
		
		jt.send("my-p2p-object", s->s.createObjectMessage(msg));
		
		
		System.out.println("done");
		
	}
	
}
