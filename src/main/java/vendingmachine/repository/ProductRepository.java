package vendingmachine.repository;

import static vendingmachine.validator.ProductValidator.*;

import java.util.HashMap;

import vendingmachine.model.Product;

public class ProductRepository {

	private final HashMap<String, Product> products;

	public ProductRepository() {
		this.products = new HashMap<>();
	}

	public void init(String rawProductsInput) {
		String[] rawProductList = rawProductsInput.split(PRODUCT_CRITERIA, -1);
		for (String rawProduct : rawProductList) {
			Product product = new Product();
			product.init(rawProduct);

			registerProduct(product);
		}
	}

	private void registerProduct(Product product) {
		String name = product.getName();
		products.put(name, product);
	}

	public boolean isExistProduct(String productName) {
		return products.containsKey(productName);
	}

	public boolean isQuantitySufficient(String productName) {
		Product product = findProduct(productName);
		return product.isInStock();
	}

	public boolean isTooExpensive(String productName, int currentDeposit) {
		Product product = findProduct(productName);
		return product.isExpensiveThan(currentDeposit);
	}

	public Product findProduct(String productName) {
		return products.get(productName);
	}

	public int getMinimumPrice() {
		int minimumPrice = Integer.MAX_VALUE;
		for (Product product : products.values()) {
			if (product.isEmpty()) {
				continue;
			}

			if (product.isExpensiveThan(minimumPrice)) {
				continue;
			}

			minimumPrice = product.getPrice();
		}

		return minimumPrice;
	}

	public boolean isOutOfStock() {
		for (Product product : products.values()) {
			if (!product.isEmpty()) {
				return false;
			}
		}

		return true;
	}

}
