package com.myco.cashier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myco.cashier.model.Cashier;
import com.myco.cashier.model.CashierSchedule;
import com.myco.cashier.service.CashierScheduleService;
import com.myco.cashier.service.CashierService;

@RestController
@RequestMapping("/cashierschedule/v1")
public class CashierScheduleController {
	
	@Autowired
	private CashierScheduleService service;
	
	@PostMapping("/schedulecashier")
	private CashierSchedule scheduleCashier(@RequestBody CashierSchedule cashierSchedule) {
		return service.saveCashierSchedule(cashierSchedule);
	}
	
//	@PostMapping("/clockin")
//	private CashierSchedule clockIn(@RequestBody ClockIn clockIn) {
//		return service.clockIn(clockIn);
//	}
}
