package com.myco.cashier.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Schedule {

	@Id
	@GeneratedValue
	private long id;

	private long cashierId;
	private int week;
	
	@OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL)
	private List<ScheduleDate> scheduleDates;
}
