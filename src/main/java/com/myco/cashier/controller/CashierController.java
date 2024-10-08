package com.myco.cashier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myco.cashier.model.Cashier;
import com.myco.cashier.service.CashierService;

@RestController
@RequestMapping("/cashier/v1")
public class CashierController {
	
	@Autowired
	private CashierService service;

	@PostMapping("/registercashier")
	private Cashier registerCashier(@RequestBody Cashier cashier) {
		return service.registerCashier(cashier);
	}
	
	@PostMapping("/schedulecashier")
	private Cashier scheduleCashier(@RequestBody Cashier cashier) {
		return service.scheduleCashier(cashier);
	}
	
//	@PostMapping("/clockin")
//	private CashierSchedule clockIn(@RequestBody ClockIn clockIn) {
//		return service.clockIn(clockIn);
//	}
}
