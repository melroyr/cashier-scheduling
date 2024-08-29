package com.myco.cashier.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myco.cashier.model.Cashier;
import com.myco.cashier.model.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
