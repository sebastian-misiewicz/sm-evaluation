package com.sm.evaluation.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sm.evaluation.api.CustomerTO;
import com.sm.evaluation.api.ICustomerService;

@Component
@ManagedBean
@ViewScoped
public class AddCustomerController {

	@Autowired
	private ICustomerService customerService;

	private CustomerTO customer;

	public void setCustomer(CustomerTO customer) {
		this.customer = customer;
	}

	public CustomerTO getCustomer() {
		if (customer == null) {
			String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
			if (!StringUtils.isEmpty(id)) {
				customer = customerService.getById(Integer.valueOf(id));
			} else {
				customer = new CustomerTO();
			}
		}

		return customer;
	}

	public void save() {
		customer = customerService.saveOrUpdate(customer);
	}

}
