package com.sm.evaluation.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sm.evaluation.api.CustomerTO;
import com.sm.evaluation.api.ICustomerService;

/**
 * Controller for customer actions.
 * 
 * @author Sebastian Misiewicz
 */
@Controller
public class CustomerController {

	@Autowired
	private ICustomerService customerService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(@RequestParam(value = "name", defaultValue = "") String name, Model model) {
		CustomerTO customerTO = null;
		if (!"".equals(name)) {
			customerTO = customerService.getByPassword(name);
		}
		model.addAttribute("customerTO", customerTO);
		model.addAttribute("name", name);
		return "index";
	}

	@RequestMapping(value = "/addcustomer.html", method = RequestMethod.GET)
	public ModelAndView addCustomerGet() {
		return new ModelAndView("editCustomer", "customerTO", new CustomerTO());
	}

	@RequestMapping(value = { "/addcustomer.html", "editcustomer.html" }, method = RequestMethod.POST)
	public String addCustomerPost(@ModelAttribute("customerTO") CustomerTO customerTO) {
		customerService.saveOrUpdate(customerTO);

		return "redirect:/";
	}

	@RequestMapping(value = "/editcustomer.html", method = RequestMethod.GET)
	public ModelAndView editCustomerGet(@RequestParam(value = "id") Integer id) {
		if (id == null) {
			throw new RuntimeException("No ID was given");
		}
		CustomerTO customerTO = customerService.getById(id);

		return new ModelAndView("editCustomer", "customerTO", customerTO);
	}

	@RequestMapping(value = "/deletecustomer.html", method = RequestMethod.GET)
	public String deleteCustomerGet(@RequestParam(value = "id") Integer id) {
		if (id == null) {
			throw new RuntimeException("No ID was given");
		}
		customerService.delete(id);

		return "redirect:/";
	}

}
