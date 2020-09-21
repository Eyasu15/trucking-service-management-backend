package com.tms.service;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.tms.models.FormReceiver;

@Service
public class SimpleServiceManager {

	private MailSender mailSender;
	private String email = "eyasuweld@gmail.com";

	public SimpleServiceManager(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void sendServiceRequest(FormReceiver receiver) {
		SimpleMailMessage msg = new SimpleMailMessage();
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
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(email);
		msg.setSubject("Authority Service Request");
		msg.setText("Name:   " + receiver.getName() + 
				"\nPhone: " + receiver.getPhone() + 
				"\nEmail: " + receiver.getEmail());
		try {
			mailSender.send(msg);
		}catch (MailException e){
			System.err.println(e.getMessage());
		}
	}
	
	public void cabCardService(FormReceiver receiver) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(email);
		msg.setSubject("Cab Card Service Request");
		msg.setText("Name:   " + receiver.getName() + 
					"\nPhone: " + receiver.getPhone() + 
					"\nEmail: " + receiver.getEmail() +
					"\nDOT:   " + receiver.getDot() +
					"\nDescription: \n\t" + receiver.getDescription());
		try {
			mailSender.send(msg);
		}catch (MailException e){
			System.err.println(e.getMessage());
		}
	}
	
	public void carrierPacket(FormReceiver receiver) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(email);
		msg.setSubject("Carrier Packet Service Request");
		msg.setText("Name:   " + receiver.getName() + 
				"\nPhone: " + receiver.getPhone() + 
				"\nEmail: " + receiver.getEmail() +
				"\nDOT:   " + receiver.getDot() +
				"\nDescription: \n\t" + receiver.getDescription());
		
		try {
			mailSender.send(msg);
		}catch (MailException e){
			System.err.println(e.getMessage());
		}
	}
}
