package com.sm.evaluation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sm.evaluation.entity.ItemBE;

public interface ItemDAO extends JpaRepository<ItemBE, Long> {

	boolean existsByName(String name);
	
	ItemBE findOneByName(String name);
	
}
