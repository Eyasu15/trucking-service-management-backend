package com.tms.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tms.service.SimpleServiceManager;

@RestController
@RequestMapping("/email")
public class ServiceRequestController {

	private final SimpleServiceManager service;

	public ServiceRequestController(SimpleServiceManager service) {
		super();
		this.service = service;
	}
	
	
}
