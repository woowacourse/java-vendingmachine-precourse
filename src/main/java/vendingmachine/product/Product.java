package vendingmachine.product;

import java.util.stream.Collectors;

import vendingmachine.machine.Machine;

public class Product {
	private String name;
	private int price;
	private int stock;

	public Product(String name, int price, int stock) {
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	public static Product findProduct(Machine machine, String productName) {
		return machine.getProductList().stream()
			.filter(p -> p.isSame(productName))
			.collect(Collectors.toList())
			.get(0);
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getStock() {
		return stock;
	}

	public boolean isSame(String productName) {
		return productName.equals(name);
	}

	public void buy() {
		stock -= 1;
	}
}
