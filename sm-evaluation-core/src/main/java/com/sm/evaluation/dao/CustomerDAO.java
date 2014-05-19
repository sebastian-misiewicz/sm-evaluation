package com.sm.evaluation.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sm.evaluation.entity.CustomerBE;

@Repository
@Transactional
public class CustomerDAO implements ICustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveOrUpdate(CustomerBE customerBE) {
		sessionFactory.getCurrentSession().saveOrUpdate(customerBE);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CustomerBE> getByName(String name) {
		Query query = sessionFactory.getCurrentSession().createQuery(//
				"select customer " + //
						"from CustomerBE as customer " + //
						"where customer.name = :name");
		query.setString("name", name);

		List<CustomerBE> customers = query.list();

		return customers;
	}

	@Override
	public CustomerBE getById(int id) {
		CustomerBE customerBE = (CustomerBE) sessionFactory.getCurrentSession().get(CustomerBE.class, id);

		return customerBE;
	}

	@Override
	public void delete(int id) {
		CustomerBE customerBE = (CustomerBE) sessionFactory.getCurrentSession().get(CustomerBE.class, id);
		sessionFactory.getCurrentSession().delete(customerBE);
	}

}
