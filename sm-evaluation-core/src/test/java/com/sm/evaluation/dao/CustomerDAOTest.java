package com.sm.evaluation.dao;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.emptyCollectionOf;
import static org.hamcrest.Matchers.hasProperty;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.sm.evaluation.entity.CustomerBE;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-context-config.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
public class CustomerDAOTest {

	@Autowired
	private ICustomerDAO customerDAO;

	@Test
	public void testSaveOrUpdate() {
		CustomerBE customerBE = new CustomerBE();
		String expectedName = "test name";
		customerBE.setName(expectedName);

		List<CustomerBE> customers = customerDAO.getByName(expectedName);
		assertThat(customers, emptyCollectionOf(CustomerBE.class));

		customerDAO.saveOrUpdate(customerBE);

		customers = customerDAO.getByName(expectedName);
		assertThat(customers, contains(hasProperty("name", equalTo(expectedName))));
	}

	@Test
	@DatabaseSetup("classpath:sampledata/few-customers.xml")
	public void testGetByName() {
		String expectedName = "Kowalski";

		List<CustomerBE> customers = customerDAO.getByName(expectedName);

		assertThat(customers, contains(hasProperty("name", equalTo(expectedName))));
	}
}
