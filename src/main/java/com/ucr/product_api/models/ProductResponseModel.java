package com.ucr.product_api.models;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductResponseModel {
	private UUID resourceId;
	private String name;
	private String description;
	private BigDecimal price;

	public ProductResponseModel() {
	}

	public ProductResponseModel(UUID resourceId, String name, String description, BigDecimal price) {
		this.resourceId = resourceId;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public UUID getResourceId() {
		return resourceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
