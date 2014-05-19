package com.sm.evaluation.api;

import java.io.Serializable;

/**
 * Transfer object for customer.
 * 
 * @author Sebastian Misiewicz
 */
public class CustomerTO implements Serializable {

	private static final long serialVersionUID = 8424151133979840610L;

	private Integer id;

	private String name;

	public CustomerTO() {
	}

	public CustomerTO(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
