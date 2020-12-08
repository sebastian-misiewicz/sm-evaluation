package com.sm.evaluation.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class CustomerController {

	@Autowired
	private ICustomerService customerService;

	public List<CustomerTO> getCustomers() {
		return customerService.getAll();
	}

}
