package com.tms.service;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.tms.models.FormReceiver;

@Service
public class SimpleServiceManager {

	private MailSender mailSender;
	private SimpleMailMessage templateMessage;
	private String email = "eyasuweld@gmail.com";

	public SimpleServiceManager(MailSender mailSender, SimpleMailMessage templateMessage) {
		super();
		this.mailSender = mailSender;
		this.templateMessage = templateMessage;
	}

	public void sendServiceRequest(FormReceiver receiver) {
		SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
		msg.setTo(email);
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
		SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
		msg.setTo(email);
		msg.setText("Name: " + receiver.getName() + 
					"\nPhone: " + receiver.getPhone() + 
					"\nEmail: " + receiver.getEmail());
	}
	
}
