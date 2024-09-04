package com.myco.cashier.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myco.cashier.model.ActualDate;
import com.myco.cashier.model.ActualSchedule;
import com.myco.cashier.model.Cashier;
import com.myco.cashier.model.CashierSchedule;
import com.myco.cashier.model.ClockIn;
import com.myco.cashier.model.Schedule;
import com.myco.cashier.model.ScheduleDate;
import com.myco.cashier.repository.CashierRepository;
import com.myco.cashier.repository.CashierScheduleRepository;
import com.myco.cashier.repository.ScheduleRepository;

@Service
public class CashierScheduleService {

	@Autowired
	private CashierScheduleRepository repository;
	
	@Autowired
	private CashierRepository cashierRepository;
	
	public CashierSchedule saveCashierSchedule(CashierSchedule cashierSchedule) {
		Cashier c = cashierRepository.findByFirstNameAndLastName(cashierSchedule.getFirstName(), 
																 cashierSchedule.getLastName());
		cashierSchedule.setCasherId(c.getId());
		return repository.save(cashierSchedule);
	}
	
	public CashierSchedule clockIn(ClockIn clockIn) {
		//Cashier c = repository.findByFirstNameAndLastName(clockIn.getFirstName(), clockIn.getLastName());
		//Get cashier schedule;
		CashierSchedule cs = new CashierSchedule();
		ScheduleDate sd = getScheduleDateByDay(getScheduleByWeek(cs));
		sd.setActualStart(new Date()); 
		return cs;
	}
	
	private Schedule getScheduleByWeek(CashierSchedule cs) {
		int week  = Integer.parseInt(new SimpleDateFormat("w").format(new java.util.Date()));
		Schedule schedule = null;
		for (Schedule s : cs.getSchedules()) {
			if (s.getWeek() == week) {
				schedule = s;
			}
		}
		return schedule;
	}
	
	private ScheduleDate getScheduleDateByDay(Schedule schedule) {
		Calendar calendar = Calendar.getInstance();
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		ScheduleDate scheduleDate = null;
		for (ScheduleDate sd : schedule.getScheduleDates()) {
			if (sd.getDay() == dayOfWeek) {
				scheduleDate = sd;
			}
		}
		return scheduleDate;
	}
}
