package vendingmachine.manager;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.domain.Product;

public class ProductManager {
	private final List<Product> productList;

	public ProductManager() {
		this.productList = new ArrayList<>();
	}

	public void addProduct(Product product) {
		productList.add(product);
	}

	public int searchProductPrice(String name) {
		Product product = searchProduct(name);
		checkProductIsNull(product);
		return product.getPrice();
	}

	public void deductQuantityOfProduct(String name, int reduceValue) {
		Product product = searchProduct(name);
		checkProductIsNull(product);
		product.reduceQuantity(reduceValue);
	}

	public boolean checkProductHaveStock(String name) {
		Product product = searchProduct(name);
		checkProductIsNull(product);
		return product.getPrice() > 0;
	}

	private Product searchProduct(String name) {
		return productList.stream()
			.filter(product -> name.equals(product.getName()))
			.findAny()
			.orElse(null);
	}

	private void checkProductIsNull(Product product) {
		if(product == null) {
			throw new IllegalArgumentException();
		}
	}
}
