package com.sm.evaluation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.sm.evaluation.dao.CustomerDAO;
import com.sm.evaluation.entity.CustomerBE;

import cucumber.api.java8.En;

@ContextConfiguration(classes = {TestContextConfiguration.class})
public class CustomerStepsDefinition implements En {

	@Autowired
	private CustomerDAO customerDAO;
	
	public CustomerStepsDefinition() {
		Given("^Customer with the name '(.+)', e-mail '(.+)'$", (String name, String email) -> {
		    CustomerBE customerBE = new CustomerBE();
		    customerBE.setEmail(email);
		    customerBE.setName(name);
			customerDAO.saveOrUpdate(customerBE);
		});
	}
	
}
