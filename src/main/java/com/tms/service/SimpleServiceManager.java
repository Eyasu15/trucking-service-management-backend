package com.tms.service;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import com.tms.models.FormReceiver;

public class SimpleServiceManager {

	private MailSender mailSender;
	private SimpleMailMessage templateMessage;
	
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void setTemplateMessage(SimpleMailMessage templateMessage) {
		this.templateMessage = templateMessage;
	}
	
	public void sendServiceRequest(FormReceiver receiver) {
		SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
		msg.setTo("garytruckingllc@yahoo.com");
		msg.setText("Name: " + receiver.getName() + 
					"\nPhone: " + receiver.getPhone() + 
					"\nEmail: " + receiver.getEmail());
	
		try {
			this.mailSender.send(msg);
		}catch (MailException e){
			System.err.println(e.getMessage());
		}
	}
}
