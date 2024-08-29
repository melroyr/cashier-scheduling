package com.myco.cashier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myco.cashier.model.Cashier;
import com.myco.cashier.service.CashierService;

@RestController
@RequestMapping("/schedule/v1")
public class ScheduleController {
	
	@Autowired
	private CashierService service;
	
	@PostMapping("/cashierschedule")
	private Cashier scheduleCashier(@RequestBody Cashier cashier) {
		return service.scheduleCashier(cashier);
	}
}
