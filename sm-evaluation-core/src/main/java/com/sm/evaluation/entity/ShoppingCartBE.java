package com.sm.evaluation.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "shoppingcart")
public class ShoppingCartBE {
	
	@Id
	@Column(name = "hash")
	private String hash;
	
	@ManyToOne
	@JoinColumn(name = "customerid")
	private CustomerBE customer;
	
	@OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<ShoppingCartItemBE> items;
	
	@Column(name = "checkoutdate")
	private LocalDateTime checkoutDate;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private ShoppingCartStatus status = ShoppingCartStatus.UNPAID;

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
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
	
	public void addItem(ShoppingCartItemBE item) {
		if (this.items == null) {
			this.items = new HashSet<>();
		}
		item.setShoppingCart(this);
		this.items.add(item);
	}

	public LocalDateTime  getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(LocalDateTime  checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public ShoppingCartStatus getStatus() {
		return status;
	}

	public void setStatus(ShoppingCartStatus status) {
		this.status = status;
	}
	
}
