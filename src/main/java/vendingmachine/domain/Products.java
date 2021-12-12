package vendingmachine.domain;

import java.util.ArrayList;

public class Products {
	private final ArrayList<Product> products = new ArrayList<>();
	private int minPrice = Integer.MAX_VALUE;
	private int totalAmount = 0;

	public Products() {
	}

	public void add(Product product) {
		products.add(product);
		minPrice = product.getMinPrice(minPrice);
		totalAmount = product.addAmount(totalAmount);
	}

	public boolean isContains(Product product) {
		return products.contains(product);
	}

	public void calculateMinPrice() {
		for(Product product : products) {
			minPrice = product.getMinPrice(minPrice);
		}
	}
}
