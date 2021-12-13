package vendingmachine.domain;

import java.util.List;

public class Product {

	private final String name;
	private final int price;
	private int quantity;

	public Product(List<String> infoList) {
		this(infoList.get(0), Integer.parseInt(infoList.get(1)), Integer.parseInt(infoList.get(2)));
	}

	public Product(String name, int price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public int decreaseQuantity() {
		return --quantity;
	}
}
