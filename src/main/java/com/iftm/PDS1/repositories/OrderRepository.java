package com.iftm.PDS1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iftm.PDS1.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	
}
