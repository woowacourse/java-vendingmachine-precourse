package vendingmachine.domain;

import java.util.List;

public class Product {
	private String name;
	private int price;
	private int quantity;

	public Product(List<String> productToString) {
		this.name = productToString.get(0);
		this.price = Integer.parseInt(productToString.get(1));
		this.quantity = Integer.parseInt(productToString.get(2));
	}

	public boolean isSameName(String name) {
		return this.name.equals(name);
	}

	private boolean isPurchaseProduct(int inputAmount) {
		return price <= inputAmount;
	}
}
