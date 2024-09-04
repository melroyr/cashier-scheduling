package com.myco.cashier.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Schedule {

	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	@JoinColumn(name = "cashierSchedule_id")
	private CashierSchedule cashierSchedule;
	
	private int week;
	
	@OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL)
	private List<ScheduleDate> scheduleDates;
}
