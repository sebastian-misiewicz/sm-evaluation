package com.sm.evaluation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shoppingcartitem")
public class ShoppingCartItemBE {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "shoppingcartid")
	private ShoppingCartBE shoppingCart;
	
	@ManyToOne
	@JoinColumn(name = "itemid")
	private ItemBE item;
	
	@Column(name = "quantity")
	private int quantity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ShoppingCartBE getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCartBE shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public ItemBE getItem() {
		return item;
	}

	public void setItem(ItemBE item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
