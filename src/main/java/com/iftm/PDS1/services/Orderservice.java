package com.iftm.PDS1.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.iftm.PDS1.entities.Order;
import com.iftm.PDS1.repositories.OrderRepository;

@Service
public class Orderservice {

	@Autowired
	private OrderRepository repository;

	
	public List<Order> findAll() {
		return repository.findAll();
	}

	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();

	}

}

