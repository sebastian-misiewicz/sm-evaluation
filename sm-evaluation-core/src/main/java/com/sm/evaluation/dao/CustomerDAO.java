package com.sm.evaluation.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sm.evaluation.entity.CustomerBE;

public interface CustomerDAO extends CrudRepository<CustomerBE, Long> {

	List<CustomerBE> findByName(String name);
	
	CustomerBE findOneByEmail(String email);
	
	boolean existsByName(String name);

	boolean existsByEmail(String email);
}
