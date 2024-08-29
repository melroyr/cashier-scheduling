package com.myco.cashier.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myco.cashier.model.Cashier;
import com.myco.cashier.model.Schedule;
import com.myco.cashier.repository.CashierRepository;
import com.myco.cashier.repository.ScheduleRepository;

@Service
public class CashierService {

	@Autowired
	private CashierRepository repository;
	
	@Autowired
	private ScheduleRepository scheduleRepository;
	
	public Cashier registerCashier(Cashier cashier) {
		
		return repository.save(cashier);
	}
	
	public Cashier scheduleCashier(Cashier cashier) {
		
		Cashier c = repository.findByFirstNameAndLastName(cashier.getFirstName(), cashier.getLastName());
		List<Schedule> schedules = cashier.getSchedule();
		for(Schedule schedule : schedules) {
			schedule.setCashierId(c.getId()); 
			scheduleRepository.save(schedule);
		}
		
		return c;
	}
}
