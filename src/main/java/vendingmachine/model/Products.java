package vendingmachine.model;

import java.util.List;

import vendingmachine.util.ErrorMessageConstants;

public class Products {
	private final List<Product> products;

	public Products(List<Product> productList) {
		this.products = productList;
	}

	public int selectMinimumPrice() {
		int minimumPrice = Integer.MAX_VALUE;
		for (Product product : products) {
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
		throw new IllegalArgumentException(ErrorMessageConstants.NO_SUCH_PRODUCT_EXCEPTION_MESSAGE);
	}

	public boolean exists() {
		for (Product product : products) {
			if (product.exists()) {
				return true;
			}
		}
		return false;
	}
}
