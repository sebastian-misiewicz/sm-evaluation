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
	 * Retrieves a customer by the given password.
	 * 
	 * @param password
	 *            the password
	 * @return {@link CustomerTO}s
	 */
	CustomerTO getByPassword(String password);

	/**
	 * Retrieves the customer by its id.
	 * 
	 * @param id
	 *            the id
	 * @return {@link CustomerTO}
	 */
	CustomerTO getById(long id);

	/**
	 * Saves or updated the given customer.
	 * 
	 * @param customerTO
	 *            the {@link CustomerTO}
	 * @return updated {@link CustomerTO}
	 */
	void saveOrUpdate(CustomerTO customerTO);

	/**
	 * Deletes a customer with given id.
	 * 
	 * @param id
	 *            the id
	 */
	void delete(long id);

}
