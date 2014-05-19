package com.sm.evaluation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import com.sm.evaluation.api.CustomerTO;
import com.sm.evaluation.api.ICustomerService;
import com.sm.evaluation.dao.ICustomerDAO;
import com.sm.evaluation.entity.CustomerBE;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private ICustomerDAO customerDAO;

	@Autowired
	private Converter<CustomerBE, CustomerTO> customerBEToCustomerTOConverter;

	@Autowired
	private Converter<CustomerTO, CustomerBE> customerTOToCustomerBEConverter;

	@Override
	public List<CustomerTO> getByName(String name) {
		List<CustomerBE> customersBes = customerDAO.getByName(name);

		List<CustomerTO> customerTOs = convert(customersBes);
		return customerTOs;
	}

	@Override
	public void saveOrUpdate(CustomerTO customerTO) {
		CustomerBE customerBE = customerTOToCustomerBEConverter.convert(customerTO);
		customerDAO.saveOrUpdate(customerBE);
	}

	@Override
	public CustomerTO getById(int id) {
		CustomerBE customerBE = customerDAO.getById(id);
		CustomerTO customerTO = customerBEToCustomerTOConverter.convert(customerBE);
		return customerTO;
	}

	@Override
	public void delete(int id) {
		customerDAO.delete(id);
	}

	private List<CustomerTO> convert(List<CustomerBE> customerBEs) {
		List<CustomerTO> customerTOs = new ArrayList<CustomerTO>();

		for (CustomerBE customerBE : customerBEs) {
			CustomerTO customerTO = customerBEToCustomerTOConverter.convert(customerBE);
			customerTOs.add(customerTO);
		}

		return customerTOs;
	}

}
