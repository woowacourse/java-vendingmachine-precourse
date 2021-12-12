package vendingmachine.dto;

import vendingmachine.domain.Products;

public class RequestRegisterProductsDto {
	private Products products;

	public RequestRegisterProductsDto(Products products) {
		this.products = products;
	}

	public Products getProducts() {
		return products;
	}
}
