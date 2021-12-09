package vendingmachine.domain;

import java.util.List;

public class Product {
	private String name;
	private String price;
	private String quantity;

	public Product(String name, String price, String quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public Product(List<String> productToString) {
		this.name = productToString.get(0);
		this.price = productToString.get(1);
		this.quantity = productToString.get(2);
	}
}
