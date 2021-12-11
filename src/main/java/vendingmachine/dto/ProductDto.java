package vendingmachine.dto;

import vendingmachine.domain.machine.product.Product;

public class ProductDto {

	private String name;
	private int price;
	private int quantity;

	public ProductDto(String name, int price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public Product toEntity() {
		return new Product(name, price, quantity);
	}

}
