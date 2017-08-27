package com.sm.evaluation;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.sm.evaluation.dao.CustomerDAO;
import com.sm.evaluation.dao.ItemDAO;
import com.sm.evaluation.dao.ShoppingCartDAO;
import com.sm.evaluation.entity.CustomerBE;
import com.sm.evaluation.entity.ItemBE;
import com.sm.evaluation.entity.ShoppingCartBE;
import com.sm.evaluation.entity.ShoppingCartItemBE;
import com.sm.evaluation.entity.ShoppingCartStatus;

import cucumber.api.java8.En;

@ContextConfiguration(classes = {TestContextConfiguration.class})
public class CustomerStepsDefinition implements En {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private ItemDAO itemDAO;
	
	@Autowired
	private ShoppingCartDAO shoppingCartDAO;
	
	public CustomerStepsDefinition() {
		Given("^Customer with the name '(.+)', e-mail '(.+)'$", (String name, String email) -> {
		    if (!customerDAO.existsByEmail(email)) {
		    	CustomerBE customerBE = new CustomerBE();
		    	customerBE.setEmail(email);
		    	customerBE.setName(name);
		    	customerDAO.save(customerBE);
		    }
		});
		
		Given("^Item '(.+)' with price ([\\d\\.]+)$", (String name, String price) -> {
			if (!itemDAO.existsByName(name)) {
				ItemBE itemBE = new ItemBE();
				itemBE.setName(name);
				itemBE.setPrice(new BigDecimal(price));
				
				itemDAO.save(itemBE);
			}
		});
		
		Given("^Customer with the email '(.+)' opens a shopping cart '(.+)'$", (String email, String cartHash) -> {
			if (!shoppingCartDAO.exists(cartHash)) {
				CustomerBE customer = customerDAO.findOneByEmail(email);
				ShoppingCartBE shoppingCartBE = new ShoppingCartBE();
				shoppingCartBE.setHash(cartHash);
				shoppingCartBE.setCustomer(customer);
				shoppingCartDAO.save(shoppingCartBE);
			}
		});

		Given("^Put '(.+)' into the cart '(.+)' in quantity (\\d+)$", (String name, String cartHash, Integer quantity) -> {
			ShoppingCartBE shoppingCartBE = shoppingCartDAO.findOne(cartHash);
			ItemBE itemBE = itemDAO.findOneByName(name);
			
			if (!shoppingCartBE.getItems().stream().anyMatch(shoppingCartItem -> shoppingCartItem.getItem().getName().equals(name))) {
				ShoppingCartItemBE shoppingCartItemBE = new ShoppingCartItemBE();
				shoppingCartItemBE.setItem(itemBE);
				shoppingCartItemBE.setQuantity(quantity);
				shoppingCartBE.addItem(shoppingCartItemBE);
				shoppingCartDAO.save(shoppingCartBE);
			};
		});
		
		Given("^Checkout the shopping cart '(.+)' with the date '(.+)'$", (String cartHash, String date) -> {
			ShoppingCartBE shoppingCartBE = shoppingCartDAO.findOne(cartHash);
			if (shoppingCartBE != null) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d HH:mm:ss");
				LocalDateTime localDate = LocalDateTime.parse(date, formatter);
				shoppingCartBE.setCheckoutDate(localDate);
				shoppingCartBE.setStatus(ShoppingCartStatus.PAID);
				shoppingCartDAO.save(shoppingCartBE);
			}
		});
	}
	
}
