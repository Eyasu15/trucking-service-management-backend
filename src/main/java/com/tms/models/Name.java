package com.tms.models;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Name {

	private String firstName;
	private String middleInitial;
	private String lastName;
}
