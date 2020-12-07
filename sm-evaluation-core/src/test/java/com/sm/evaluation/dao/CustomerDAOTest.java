package com.sm.evaluation.dao;

import static org.assertj.core.api.Assertions.assertThat;

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
	private CustomerDAO customerDAO;

	@Test
	public void testSaveOrUpdate() {
		CustomerBE customerBE = new CustomerBE();
		String expectedName = "test name";
		customerBE.setName(expectedName);

		List<CustomerBE> customers = customerDAO.getByName(expectedName);
		assertThat(customers).isEmpty();

		customerDAO.saveOrUpdate(customerBE);

		customers = customerDAO.getByName(expectedName);
		assertThat(customers).extracting("name").contains(expectedName);
	}

	@Test
	@DatabaseSetup("classpath:sampledata/test-customers.xml")
	public void testGetByNameTestData() {
		String expectedName = "Benjamin";

		List<CustomerBE> customers = customerDAO.getByName(expectedName);

		assertThat(customers).extracting("name").contains(expectedName);
	}
	
	@Test
	@DatabaseSetup("classpath:sampledata/production-10000-customers.xml")
	public void testGetByNameProductionData() {
		String expectedName = "Benjamin";

		List<CustomerBE> customers = customerDAO.getByName(expectedName);

		assertThat(customers).extracting("name").contains(expectedName);
	}
}
