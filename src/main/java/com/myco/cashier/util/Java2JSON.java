package com.myco.cashier.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.myco.cashier.model.Cashier;
import com.myco.cashier.model.Schedule;
import com.myco.cashier.model.ScheduleDate;

public class Java2JSON {
	
	public static void main(String[] args) throws JsonProcessingException, ParseException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		
		Cashier cashier = new Cashier();
		cashier.setFirstName("Melroy");
		cashier.setLastName("Cashier");
		Map<Integer, Schedule> schedule = new HashMap<Integer, Schedule>();
		DateFormat parseFormat = new SimpleDateFormat(
                "yyyy-MM-dd'T'HH:mm:ss");
		List<Schedule> schedules = new ArrayList<>();
		Schedule s = new Schedule();
		
		List<ScheduleDate> scheduleDates = new ArrayList<>();
		ScheduleDate scheduleDate = new ScheduleDate();
		scheduleDate.setScheduleStart(parseFormat.parse("2024-08-26T12:00:00"));
		scheduleDate.setScheduleEnd(parseFormat.parse("2024-08-26T17:00:00"));
		scheduleDates.add(scheduleDate);
		
		scheduleDate = new ScheduleDate();
		scheduleDate.setScheduleStart(parseFormat.parse("2024-08-27T12:00:00"));
		scheduleDate.setScheduleEnd(parseFormat.parse("2024-08-27T17:00:00"));
		scheduleDates.add(scheduleDate);
		
		scheduleDate = new ScheduleDate();
		scheduleDate.setScheduleStart(parseFormat.parse("2024-08-29T12:00:00"));
		scheduleDate.setScheduleEnd(parseFormat.parse("2024-08-29T17:00:00"));
		scheduleDates.add(scheduleDate);
		
		scheduleDate = new ScheduleDate();
		scheduleDate.setScheduleStart(parseFormat.parse("2024-08-30T12:00:00"));
		scheduleDate.setScheduleEnd(parseFormat.parse("2024-08-30T17:00:00"));
		scheduleDates.add(scheduleDate);
		
		scheduleDate = new ScheduleDate();
		scheduleDate.setScheduleStart(parseFormat.parse("2024-08-31T12:00:00"));
		scheduleDate.setScheduleEnd(parseFormat.parse("2024-08-31T17:00:00"));
		scheduleDates.add(scheduleDate);
		s.setWeek(32);
		s.setScheduleDates(scheduleDates);
		schedules.add(s);
		
        cashier.setSchedule(schedules);
		String json = ow.writeValueAsString(cashier);
		
		System.out.println("JSON: " + json);

	}
}
