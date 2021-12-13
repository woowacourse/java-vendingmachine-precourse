package vendingmachine.domain;

import java.util.ArrayList;

public class Products {
	private final ArrayList<Product> products = new ArrayList<>();

	public void add(Product product) {
		products.add(product);
	}

	public boolean isContains(Product product) {
		return products.contains(product);
	}

	public boolean isLessThanMinPrice(int price) {
		return price < getMinPrice();
	}

	public int getMinPrice() {
		int minPrice = Integer.MAX_VALUE;
		for (Product product : products) {
			minPrice = product.getSmallerPrice(minPrice);
		}
		return minPrice;
	}

	public int getTotalAmount() {
		int totalAmount = 0;
		for (Product product : products) {
			totalAmount = product.addAmount(totalAmount);
		}
		return totalAmount;
	}

	public Product getProductByName(String name) {
		return products.stream()
			.filter((product) -> product.isSameName(name))
			.findFirst()
			.orElseThrow(IllegalArgumentException::new);
	}
}
