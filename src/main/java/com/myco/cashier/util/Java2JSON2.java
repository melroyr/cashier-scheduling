package com.myco.cashier.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.myco.cashier.model.CashierSchedule;
import com.myco.cashier.model.Schedule;
import com.myco.cashier.model.ScheduleDate;

public class Java2JSON2 {
	
	public static void main(String[] args) throws JsonProcessingException, ParseException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

		DateFormat parseFormat = new SimpleDateFormat(
                "yyyy-MM-dd'T'HH:mm:ss");
		
		CashierSchedule cs = new CashierSchedule();
		cs.setFirstName("Melroy");
		cs.setLastName("Cashier");
		
		List<Schedule> schedules = new ArrayList<>();
		Schedule s = new Schedule();
		s.setWeek(36);
		
		List<ScheduleDate> scheduleDates = new ArrayList<>();
		
		ScheduleDate sd = new ScheduleDate();
		sd.setDay(4);
		sd.setScheduleStart(parseFormat.parse("2024-09-04T12:00:00"));
		sd.setScheduleEnd(parseFormat.parse("2024-09-04T17:00:00"));
		scheduleDates.add(sd);
		
		sd = new ScheduleDate();
		sd.setDay(6);
		sd.setScheduleStart(parseFormat.parse("2024-09-06T12:00:00"));
		sd.setScheduleEnd(parseFormat.parse("2024-09-06T17:00:00"));
		scheduleDates.add(sd);
		
		sd = new ScheduleDate();
		sd.setDay(7);
		sd.setScheduleStart(parseFormat.parse("2024-09-07T12:00:00"));
		sd.setScheduleEnd(parseFormat.parse("2024-09-07T17:00:00"));
		scheduleDates.add(sd);
		
		sd = new ScheduleDate();
		sd.setDay(2);
		sd.setScheduleStart(parseFormat.parse("2024-09-02T12:00:00"));
		sd.setScheduleEnd(parseFormat.parse("2024-09-02T17:00:00"));
		scheduleDates.add(sd);
		
		sd = new ScheduleDate();
		sd.setDay(3);
		sd.setScheduleStart(parseFormat.parse("2024-09-03T12:00:00"));
		sd.setScheduleEnd(parseFormat.parse("2024-09-03T17:00:00"));
		scheduleDates.add(sd);
		
		s.setScheduleDates(scheduleDates);
		schedules.add(s);
		
		cs.setSchedules(schedules);
				
		String json = ow.writeValueAsString(cs);
		
		System.out.println("JSON: " + json);

	}
}
