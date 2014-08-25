package com.sm.evaluation.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sm.evaluation.entity.CustomerBE;

@Component
public class CustomerCache {

	private Map<String, CustomerBE> cache;

	@Autowired
	private CustomerDAO customerDAO;

	public CustomerBE getByPassword(String password) {
		init();
		
		CustomerBE customerBE = cache.get(password);
		return customerBE;
	}

	private void init() {
		if (cache == null) {
			cache = new HashMap<String, CustomerBE>();
			
			List<CustomerBE> allCustomers = customerDAO.getAll();
			for(CustomerBE customerBE : allCustomers) {
				cache.put(customerBE.getPassword(), customerBE);
			}
		}
	}

}
