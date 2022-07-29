package com.sparta.northwind.entities;

import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;

@Entity
@Table(name = "customerdemographics")
public class Customerdemographic extends RepresentationModel<Customerdemographic> {
	@Id
	@Column(name = "CustomerTypeID", nullable = false, length = 10)
	private String id;

	@Lob
	@Column(name = "CustomerDesc")
	private String customerDesc;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomerDesc() {
		return customerDesc;
	}

	public void setCustomerDesc(String customerDesc) {
		this.customerDesc = customerDesc;
	}

}