package com.tms.models;

import lombok.Data;

@Data
public class Bol {

	private String loadNumber;
	private String from;
	private String to;
	private Long amount;
	private String notes;
	
	
}
