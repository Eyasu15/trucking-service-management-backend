package com.tms.service;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.tms.models.FormReceiver;

@Service
public class SimpleServiceManager {

	private MailSender mailSender = new JavaMailSenderImpl();
	private SimpleMailMessage templateMessage = new SimpleMailMessage();
	




	public void sendServiceRequest(FormReceiver receiver) {
		SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
		msg.setTo("eyasuweld@gmail.com");
		msg.setText("Name: " + receiver.getName() + 
					"\nPhone: " + receiver.getPhone() + 
					"\nEmail: " + receiver.getEmail());
	
		try {
			mailSender.send(msg);
		}catch (MailException e){
			System.err.println(e.getMessage());
		}
	}
	
	public void authorityService(FormReceiver receiver) {
		
	}
}
