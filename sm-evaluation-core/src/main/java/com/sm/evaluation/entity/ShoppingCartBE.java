package com.sm.evaluation.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "shoppingcart")
public class ShoppingCartBE {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "customerid")
	private CustomerBE customer;
	
	@OneToMany(mappedBy = "shoppingCart")
	private Set<ShoppingCartItemBE> items;
	
	@Column(name = "checkoutdate")
	private Date checkoutDate;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private ShoppingCartStatus status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CustomerBE getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerBE customer) {
		this.customer = customer;
	}

	public Set<ShoppingCartItemBE> getItems() {
		return items;
	}

	public void setItems(Set<ShoppingCartItemBE> items) {
		this.items = items;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public ShoppingCartStatus getStatus() {
		return status;
	}

	public void setStatus(ShoppingCartStatus status) {
		this.status = status;
	}
	
}
