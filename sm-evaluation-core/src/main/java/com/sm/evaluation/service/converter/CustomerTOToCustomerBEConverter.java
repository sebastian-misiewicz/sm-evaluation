package com.sm.evaluation.service.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sm.evaluation.api.CustomerTO;
import com.sm.evaluation.entity.CustomerBE;

/**
 * Converter from {@link CustomerTO} to {@link CustomerBE}.
 * 
 * @author Sebastian Misiewicz
 * 
 */
@Component
public class CustomerTOToCustomerBEConverter implements Converter<CustomerTO, CustomerBE> {

	@Override
	public CustomerBE convert(CustomerTO customerTO) {
		CustomerBE customerBE = new CustomerBE();

		customerBE.setId(customerTO.getId());
		customerBE.setName(customerTO.getName());
		return customerBE;
	}

}
