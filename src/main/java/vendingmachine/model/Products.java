package vendingmachine.model;

import java.util.List;

public class Products {
	private final List<Product> products;

	public Products(List<Product> productList) {
		this.products = productList;
	}

	public int selectMinimumPrice() {
		int minimumPrice = Integer.MAX_VALUE;
		for (Product product: products) {
			if (product.exists()) {
				minimumPrice = product.compareMinimumPrice(minimumPrice);
			}
		}
		return minimumPrice;
	}

	public Product findProduct(String inputPurchaseProduct) {
		for (Product product : products) {
			if (product.equalProductName(inputPurchaseProduct)) {
				return product;
			}
		}
		throw new IllegalArgumentException();
	}
}
