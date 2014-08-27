package com.sm.evaluation.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sm.evaluation.api.CustomerTO;
import com.sm.evaluation.entity.CustomerBE;
import com.sm.evaluation.service.converter.CustomerBEToCustomerTOConverter;

@Component
public class CustomerCache {

	private Map<String, CustomerTO> cache;

	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private CustomerBEToCustomerTOConverter customerBEToCustomerTOConverter;

	public CustomerTO getByPassword(String password) {
		init();
		
		CustomerTO customerTO = cache.get(password);
		return customerTO;
	}

	private void init() {
		if (cache == null) {
			cache = new HashMap<String, CustomerTO>();
			
			List<CustomerBE> allCustomers = customerDAO.getAll();
			for(CustomerBE customerBE : allCustomers) {
				cache.put(customerBE.getPassword(), customerBEToCustomerTOConverter.convert(customerBE));
			}
		}
	}

}
