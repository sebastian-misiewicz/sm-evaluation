package com.sm.evaluation.entity;

import java.util.Date;

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
	
	@Column(name = "comment", length = 10000)
	private String comment;
	
	@Column(name = "registerdate")
	private Date registerDate;
	
	@Column(name = "logindate")
	private Date loginDate;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

}
