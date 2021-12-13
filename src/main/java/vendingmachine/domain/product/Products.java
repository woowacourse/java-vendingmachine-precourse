package vendingmachine.domain.product;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import vendingmachine.constant.Notification;
import vendingmachine.domain.money.Money;

public class Products {
	private final Map<String, Product> products;

	private Products(Map<String, Product> products) {
		this.products = products;
	}

	public static Products from() {
		return new Products(new HashMap<>());
	}

	public void add(Product product) {
		validateNull(product);
		String name = product.getName();
		validateDuplication(name);
		products.put(name, product);
	}

	public void addAll(Products products) {
		Collection<Product> productCollection = products.getProducts().values();
		for (Product product : productCollection) {
			add(product);
		}
	}

	private void validateNull(Product product) {
		try {
			Objects.requireNonNull(product);
		} catch (NullPointerException e) {
			throw new IllegalArgumentException(Notification.PRODUCT_IS_NULL.getMessage());
		}
	}

	private void validateDuplication(String name) {
		if (products.containsKey(name)) {
			throw new IllegalArgumentException(Notification.PRODUCT_ALREADY_EXIST.getMessage());
		}
	}

	public Map<String, Product> getProducts() {
		return new HashMap<>(products);
	}

	public Money purchaseProduct(String productName) {
		validateProductName(productName);
		Product product = products.get(productName);
		product.decreaseStock();
		return product.getPrice();
	}

	private void validateProductName(String productName) {
		if (!products.containsKey(productName)) {
			throw new IllegalArgumentException(Notification.PRODUCT_NOT_FOUND.getMessage());
		}
	}

	public boolean isPurchasable(Money money) {
		Collection<Product> productCollection = products.values();
		return productCollection.stream()
			.anyMatch(product -> product.isPurchasable(money));
	}
}
