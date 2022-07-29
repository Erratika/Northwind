package com.sparta.northwind.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class ProductDto implements Serializable {
	private final Integer id;
	private final String productName;
	private final String quantityPerUnit;
	private final BigDecimal unitPrice;
	private final Integer unitsInStock;
	private final Integer unitsOnOrder;
	private final Integer reorderLevel;
	private final Boolean discontinued;

	public ProductDto(Integer id, String productName, String quantityPerUnit, BigDecimal unitPrice, Integer unitsInStock, Integer unitsOnOrder, Integer reorderLevel, Boolean discontinued) {
		this.id = id;
		this.productName = productName;
		this.quantityPerUnit = quantityPerUnit;
		this.unitPrice = unitPrice;
		this.unitsInStock = unitsInStock;
		this.unitsOnOrder = unitsOnOrder;
		this.reorderLevel = reorderLevel;
		this.discontinued = discontinued;
	}

	public Integer getId() {
		return id;
	}

	public String getProductName() {
		return productName;
	}

	public String getQuantityPerUnit() {
		return quantityPerUnit;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public Integer getUnitsInStock() {
		return unitsInStock;
	}

	public Integer getUnitsOnOrder() {
		return unitsOnOrder;
	}

	public Integer getReorderLevel() {
		return reorderLevel;
	}

	public Boolean getDiscontinued() {
		return discontinued;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ProductDto entity = (ProductDto) o;
		return Objects.equals(this.id, entity.id) &&
				Objects.equals(this.productName, entity.productName) &&
				Objects.equals(this.quantityPerUnit, entity.quantityPerUnit) &&
				Objects.equals(this.unitPrice, entity.unitPrice) &&
				Objects.equals(this.unitsInStock, entity.unitsInStock) &&
				Objects.equals(this.unitsOnOrder, entity.unitsOnOrder) &&
				Objects.equals(this.reorderLevel, entity.reorderLevel) &&
				Objects.equals(this.discontinued, entity.discontinued);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, productName, quantityPerUnit, unitPrice, unitsInStock, unitsOnOrder, reorderLevel, discontinued);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" +
				"id = " + id + ", " +
				"productName = " + productName + ", " +
				"quantityPerUnit = " + quantityPerUnit + ", " +
				"unitPrice = " + unitPrice + ", " +
				"unitsInStock = " + unitsInStock + ", " +
				"unitsOnOrder = " + unitsOnOrder + ", " +
				"reorderLevel = " + reorderLevel + ", " +
				"discontinued = " + discontinued + ")";
	}
}
