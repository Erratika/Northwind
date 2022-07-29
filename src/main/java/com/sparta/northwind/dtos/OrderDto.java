package com.sparta.northwind.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

public class OrderDto implements Serializable {
	private final Integer id;
	private final Instant orderDate;
	private final Instant requiredDate;
	private final Instant shippedDate;
	private final BigDecimal freight;
	private final String shipName;
	private final String shipAddress;
	private final String shipCity;
	private final String shipRegion;
	private final String shipPostalCode;
	private final String shipCountry;

	public OrderDto(Integer id, Instant orderDate, Instant requiredDate, Instant shippedDate, BigDecimal freight, String shipName, String shipAddress, String shipCity, String shipRegion, String shipPostalCode, String shipCountry) {
		this.id = id;
		this.orderDate = orderDate;
		this.requiredDate = requiredDate;
		this.shippedDate = shippedDate;
		this.freight = freight;
		this.shipName = shipName;
		this.shipAddress = shipAddress;
		this.shipCity = shipCity;
		this.shipRegion = shipRegion;
		this.shipPostalCode = shipPostalCode;
		this.shipCountry = shipCountry;
	}

	public Integer getId() {
		return id;
	}

	public Instant getOrderDate() {
		return orderDate;
	}

	public Instant getRequiredDate() {
		return requiredDate;
	}

	public Instant getShippedDate() {
		return shippedDate;
	}

	public BigDecimal getFreight() {
		return freight;
	}

	public String getShipName() {
		return shipName;
	}

	public String getShipAddress() {
		return shipAddress;
	}

	public String getShipCity() {
		return shipCity;
	}

	public String getShipRegion() {
		return shipRegion;
	}

	public String getShipPostalCode() {
		return shipPostalCode;
	}

	public String getShipCountry() {
		return shipCountry;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		OrderDto entity = (OrderDto) o;
		return Objects.equals(this.id, entity.id) &&
				Objects.equals(this.orderDate, entity.orderDate) &&
				Objects.equals(this.requiredDate, entity.requiredDate) &&
				Objects.equals(this.shippedDate, entity.shippedDate) &&
				Objects.equals(this.freight, entity.freight) &&
				Objects.equals(this.shipName, entity.shipName) &&
				Objects.equals(this.shipAddress, entity.shipAddress) &&
				Objects.equals(this.shipCity, entity.shipCity) &&
				Objects.equals(this.shipRegion, entity.shipRegion) &&
				Objects.equals(this.shipPostalCode, entity.shipPostalCode) &&
				Objects.equals(this.shipCountry, entity.shipCountry);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, orderDate, requiredDate, shippedDate, freight, shipName, shipAddress, shipCity, shipRegion, shipPostalCode, shipCountry);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" +
				"id = " + id + ", " +
				"orderDate = " + orderDate + ", " +
				"requiredDate = " + requiredDate + ", " +
				"shippedDate = " + shippedDate + ", " +
				"freight = " + freight + ", " +
				"shipName = " + shipName + ", " +
				"shipAddress = " + shipAddress + ", " +
				"shipCity = " + shipCity + ", " +
				"shipRegion = " + shipRegion + ", " +
				"shipPostalCode = " + shipPostalCode + ", " +
				"shipCountry = " + shipCountry + ")";
	}
}
