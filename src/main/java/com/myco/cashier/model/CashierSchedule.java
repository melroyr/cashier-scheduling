package com.myco.cashier.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CashierSchedule {
	
	@Id
	@GeneratedValue
	private long id;
	
	private long casherId;
	private String firstName;
	private String lastName;
	
	@OneToMany(mappedBy = "cashierSchedule")
	List<Schedule> schedules;

}
