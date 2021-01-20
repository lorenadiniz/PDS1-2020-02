package com.iftm.PDS1.repositories;

import com.iftm.PDS1.entities.Orderitem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderItemRepository extends JpaRepository<Orderitem, Long> {


}
