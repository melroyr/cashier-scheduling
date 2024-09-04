package com.myco.cashier.model;

import java.util.List;

import lombok.Data;

@Data
public class ActualSchedule {

	private int week;
	List<ActualDate> actualDatea;
}
