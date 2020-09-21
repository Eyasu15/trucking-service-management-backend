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
@RequestMapping("/email")
@CrossOrigin
public class ServiceRequestController {

	private final SimpleServiceManager service;

	public ServiceRequestController(SimpleServiceManager service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/getAuthority")
	public ResponseEntity<Object> sendMessage(@RequestBody FormReceiver receiver) {
		service.authorityService(receiver);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
