package com.sparta.northwind.entities;

import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shippers")
public class Shipper extends RepresentationModel<Shipper> {
	@Id
	@Column(name = "ShipperID", nullable = false)
	private Integer id;

	@Column(name = "CompanyName", nullable = false, length = 40)
	private String companyName;

	@Column(name = "Phone", length = 24)
	private String phone;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}