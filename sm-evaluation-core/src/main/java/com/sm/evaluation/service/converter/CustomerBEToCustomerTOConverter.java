package com.sm.evaluation.service.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sm.evaluation.api.CustomerTO;
import com.sm.evaluation.entity.CustomerBE;

/**
 * Converter from {@link CustomerBE} to {@link CustomerTO}.
 * 
 * @author Sebastian Misiewicz
 * 
 */
@Component
public class CustomerBEToCustomerTOConverter implements Converter<CustomerBE, CustomerTO> {

	@Override
	public CustomerTO convert(CustomerBE customerBE) {
		CustomerTO customerTO = new CustomerTO(customerBE.getId(), customerBE.getName());
		return customerTO;
	}

}
