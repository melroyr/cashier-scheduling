package com.myco.cashier.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myco.cashier.model.Cashier;

public interface CashierRepository extends JpaRepository<Cashier, Long> {

	Cashier findByFirstNameAndLastName(String firstName, String lastName);
}
