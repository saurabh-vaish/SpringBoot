package com.app.util;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

/**
 * 
 * java Mail Api is used to send email in java , but its code is lengthy so spring framework provided JavaMailSender(I) which simplifies code.
 * 	JavaMailSender(I) --- JavaMailSenderImpl(c)
 * 
 *   Spring Boot does not require configuration of JavaMailSender , it automatically configure based on keys provided using auto configuration.
 *   
 *   JavaMailSenderImpl provide connection and login to mail server .
 *   
 *   Sending Email ,Cc ,Bcc , attachments etc is done with the help of MimeMessage .
 *   
 *   We first create MimeMessage object then with the help of MimeMessageHelper we send email to others 
 * 
 * 	For sending file java used FileSystemResource(from harddrive) , ClassPathResource(from src/main/resource)  ---  for normal java app
 * 								MultipartFileResource  --- for web apps 	
 * 
 * 
 * ***/

@Component
public class EmailUtil {

	
	@Autowired
	private JavaMailSender mailSender;
	
	public boolean send(String to,String subject,String text,
						//String cc, String bcc,
						FileSystemResource file) {
		
		boolean flag=false;
		
		try {
		
			// create MimeMessage Object
			MimeMessage message = mailSender.createMimeMessage();
			
			// Helper class object to send mail
			MimeMessageHelper helper = new MimeMessageHelper(message, file!=null?true:false);   /// check attachment or not
			
			helper.setTo(to);
			helper.setFrom("srvjava93@gmail.com");
			helper.setSubject(subject);
			helper.setText(text);
			
		//	helper.setCc(cc);   // String [] inputs
		//	helper.setBcc(bcc);   // String [] inputs
			
			if(file!=null)
			{
				helper.addAttachment(file.getFilename(), file);
			}
			
			
			// send message
			mailSender.send(message);
			
			flag=true;
		}
		catch (Exception e) {
			e.printStackTrace();
			flag=false;
		}
	
		return flag;

		
	}
	
}
