package com.tms.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tms.models.FormReceiver;
import com.tms.service.SimpleServiceManager;

@RestController
@RequestMapping("/service")
@CrossOrigin
public class ServiceRequestController {

	private final SimpleServiceManager service;

	public ServiceRequestController(SimpleServiceManager service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/getAuthority")
	public ResponseEntity<Object> authority(@RequestBody FormReceiver receiver) {
		service.authorityService(receiver);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@PostMapping("/cabcard")
	public ResponseEntity<Object> cabCard(@RequestBody FormReceiver receiver) {
		service.cabCardService(receiver);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@PostMapping("/carrierPacket")
	public ResponseEntity<Object> carrierPacket(@RequestBody FormReceiver receiver) {
		service.carrierPacketService(receiver);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@PostMapping("/dispatch")
	public ResponseEntity<Object> dispatch(@RequestBody FormReceiver receiver) {
		service.dispatchService(receiver);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@PostMapping("/form2290")
	public ResponseEntity<Object> form2290(@RequestBody FormReceiver receiver) {
		service.form2290Service(receiver);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@PostMapping("/ifta")
	public ResponseEntity<Object> ifta(@RequestBody FormReceiver receiver) {
		service.iftaService(receiver);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@PostMapping("/ucrRegistration")
	public ResponseEntity<Object> ucrRegistration(@RequestBody FormReceiver receiver) {
		service.ucrRegistrationService(receiver);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
