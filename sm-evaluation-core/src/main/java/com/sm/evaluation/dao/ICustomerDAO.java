package com.sm.evaluation.dao;

import java.util.List;

import com.sm.evaluation.entity.CustomerBE;

/**
 * DAO operations for {@link CustomerBE}.
 * 
 * @author Sebastian Misiewicz
 */
public interface ICustomerDAO {

	/**
	 * Saves or updates giben customer.
	 * 
	 * @param customerBE
	 *            the {@link CustomerBE}
	 */
	void saveOrUpdate(CustomerBE customerBE);

	/**
	 * Gets customers by the given name.
	 * 
	 * @param name
	 *            the name
	 * @return {@link List} of {@link CustomerBE}s
	 */
	List<CustomerBE> getByName(String name);

	/**
	 * Gets the customer by its id.
	 * 
	 * @param id
	 *            the id
	 * @return the {@link CustomerBE}
	 */
	CustomerBE getById(int id);

	/**
	 * Deletes customer with given ID.
	 * 
	 * @param id
	 *            the id
	 */
	void delete(int id);

}
