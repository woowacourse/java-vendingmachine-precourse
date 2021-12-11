package vendingmachine.manager;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.domain.Product;

public class ProductManager {
	private final List<Product> productList;

	public ProductManager() {
		this.productList = new ArrayList<>();
	}

	public void addAllProduct(List<Product> products) {
		productList.addAll(products);
	}

	public void checkProductExist(String name) throws IllegalArgumentException{
		Product product = searchProduct(name);
		if(product == null) {
			throw new IllegalArgumentException();
		}
	}

	public Product searchProduct(String name) {
		return productList.stream()
			.filter(product -> name.equals(product.getName()))
			.findAny()
			.orElse(null);
	}
}
