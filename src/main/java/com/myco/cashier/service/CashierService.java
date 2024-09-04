package com.myco.cashier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myco.cashier.model.Cashier;
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
		c.setSchedule(cashier.getSchedule());		
		repository.save(c);
		return c;
		
	}
	
//	public CashierSchedule clockIn(ClockIn clockIn) {
//		//Cashier c = repository.findByFirstNameAndLastName(clockIn.getFirstName(), clockIn.getLastName());
//		//Get cashier schedule;
//		CashierSchedule cs = new CashierSchedule();
//		ActualDate ad = actualDateByDay(actualScheduleByWeek(cs));
//		ad.setActualStart(new Date()); 
//		return cs;
//	}
	
//	private Schedule actualScheduleByWeek(CashierSchedule cs) {
//		int week  = Integer.parseInt(new SimpleDateFormat("w").format(new java.util.Date()));
//		Schedule schedule = null;
//		for (Schedule s : cs.getSchedules()) {
//			if (s.getWeek() == week) {
//				schedule = s;
//			}
//		}
//		return schedule;
//	}
//	
//	private ActualDate actualDateByDay(ActualSchedule as) {
//		Calendar calendar = Calendar.getInstance();
//		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
//		ActualDate actualDate = null;
//		for (ActualDate ad : as.getActualDatea()) {
//			if (ad.getDay() == dayOfWeek) {
//				actualDate = ad;
//			}
//		}
//		return actualDate;
//	}
}
