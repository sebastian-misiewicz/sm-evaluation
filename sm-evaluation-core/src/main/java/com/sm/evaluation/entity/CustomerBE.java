package com.sm.evaluation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerBE {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "title", length = 10)
	private String title;

	@Column(name = "name", nullable = false, length = 30)
	private String name;

	@Column(name = "password", length = 20)
	private String password;

	@Column(name = "email", length = 200)
	private String email;
	
	@Column(name = "company", length = 300)
	private String company;
	
	@Column(name = "address", length = 200)
	private String address;
	
	@Column(name = "city", length = 100)
	private String city;
	
	@Column(name = "postalcode", length = 20)
	private String postalCode;
	
	@Column(name = "country", length = 50)
	private String country;
	
	@Column(name = "phone", length = 100)
	private String phone;
	
	@Column(name = "fax", length = 100)
	private String fax;
	
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

}
