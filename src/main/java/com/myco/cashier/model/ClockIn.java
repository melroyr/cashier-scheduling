package com.myco.cashier.model;

import java.util.Date;

import lombok.Data;

@Data
public class ClockIn {
	
	private String firstName;
	private String lastName;
	private Date clockIn;

}
