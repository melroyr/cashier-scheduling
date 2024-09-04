package com.myco.cashier.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.myco.cashier.model.Cashier;
import com.myco.cashier.model.ClockIn;
import com.myco.cashier.model.Schedule;
import com.myco.cashier.model.ScheduleDate;

public class Java2JSON {
	
	public static void main(String[] args) throws JsonProcessingException, ParseException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		
		ClockIn clockIn = new ClockIn();
		clockIn.setFirstName("Melroy");
		clockIn.setLastName("Cashier");
		DateFormat parseFormat = new SimpleDateFormat(
                "yyyy-MM-dd'T'HH:mm:ss");
		clockIn.setClockIn(parseFormat.parse("2024-08-26T12:00:00"));
		
		Date date = new Date(System.currentTimeMillis());
		parseFormat = new SimpleDateFormat(
                "yyyy-MM-dd");
		System.out.println("Date: " + parseFormat.format(date));
		parseFormat = new SimpleDateFormat(
                "HH:mm:ss");
		System.out.println("Time: " + parseFormat.format(date));
		
		String week = new SimpleDateFormat("w").format(new java.util.Date());
		System.out.println("Week: " + week);
		
		Calendar calendar = Calendar.getInstance();
		System.out.println("day of week: " + calendar.get(Calendar.DAY_OF_WEEK));
		
		String json = ow.writeValueAsString(clockIn);
		
		System.out.println("JSON: " + json);

	}
}
