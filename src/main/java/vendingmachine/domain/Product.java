package vendingmachine.domain;

import java.util.List;

import vendingmachine.service.ProductService;

public class Product {
	private String name;
	private int price;
	private int count;

	private Product(String name, int price, int count) {
		this.name = name;
		this.price = price;
		this.count = count;
	}

	public static Product makeProduct(String inputLine) {
		List<String> strings = ProductService.splitByComma(inputLine);
		return new Product(strings.get(0), Integer.parseInt(strings.get(1)), Integer.parseInt(strings.get(2)));
	}

	public boolean isSameName(String name) {
		return this.name.equals(name);
	}

	public boolean hasMoreThanOneCount() {
		return this.count > 0;
	}
}

