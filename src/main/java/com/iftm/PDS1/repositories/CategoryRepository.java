package com.iftm.PDS1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.iftm.PDS1.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	
}
