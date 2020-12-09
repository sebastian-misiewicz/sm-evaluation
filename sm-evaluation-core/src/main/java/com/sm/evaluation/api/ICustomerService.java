package com.sm.evaluation.api;

import java.util.List;

/**
 * Customer operations.
 * 
 * @author Sebastian Misiewicz
 */
public interface ICustomerService {

	/**
	 * Retrieves all customers by the given name.
	 * 
	 * @param name
	 *            the name
	 * @return {@link List} of {@link CustomerTO}s
	 */
	List<CustomerTO> getByName(String name);
	
	/**
	 * Retrieves the customer by its id.
	 * 
	 * @param id
	 *            the id
	 * @return {@link CustomerTO}
	 */
	CustomerTO getById(int id);

	/**
	 * Saves or updated the given customer.
	 * 
	 * @param customerTO
	 *            the {@link CustomerTO}
	 * @return updated {@link CustomerTO}
	 */
	CustomerTO saveOrUpdate(CustomerTO customerTO);

    List<CustomerTO> getAll();
}
