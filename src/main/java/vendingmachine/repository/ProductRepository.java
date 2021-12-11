package vendingmachine.repository;

import java.util.ArrayList;
import java.util.List;

import exception.OrderException;
import vendingmachine.model.Product;

public class ProductRepository {
	private List<Product> productList = new ArrayList<>();

	public List<Product> getProductList() {
		return productList;
	}

	public void addProduct(Product product) {
		productList.add(product);
	}

	// public Product findByName(String name) {
	// 	OrderException.isExistOrder(name, productList);
	// 	return productList.stream()
	// 		.filter(product -> name.equals(product.getName()))
	// 		.findAny().get();
	// }
}
