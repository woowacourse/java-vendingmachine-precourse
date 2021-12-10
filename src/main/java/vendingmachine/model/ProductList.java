package vendingmachine.model;

import static vendingmachine.validator.ProductValidator.*;

import java.util.HashMap;

// TODO: 2021/12/08 더 좋은 이름
public class ProductList {

	private final HashMap<String, Product> hashMap;

	public ProductList() {
		this.hashMap = new HashMap<>();
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
		hashMap.put(name, product);
	}

	public boolean isExistProduct(String productName) {
		return hashMap.containsKey(productName);
	}

	public boolean isQuantitySufficient(String productName) {
		Product product = findProduct(productName);
		return product.getQuantity() > 0;
	}

	public boolean isTooExpensive(String productName, int currentDeposit) {
		Product product = findProduct(productName);
		return product.getPrice() > currentDeposit;
	}

	public Product findProduct(String productName) {
		return hashMap.get(productName);
	}

	public int getMinimumPrice() {
		int minimumPrice = Integer.MAX_VALUE;
		for (Product product : hashMap.values()) {
			if (product.isEmpty()) {
				continue;
			}

			minimumPrice = Math.min(minimumPrice, product.getPrice());
		}

		return minimumPrice;
	}

	public boolean isOutOfStock() {
		for (Product product : hashMap.values()) {
			if (!product.isEmpty()) {
				return false;
			}
		}

		return true;
	}

}
