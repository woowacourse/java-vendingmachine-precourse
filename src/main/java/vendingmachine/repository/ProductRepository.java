package vendingmachine.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import vendingmachine.domain.Product;

public class ProductRepository {

	private Map<String, Product> productMap;

	public ProductRepository() {
		this.productMap = new HashMap<>();
	}

	public void save(List<Product> productList) {
		productList.forEach(product -> productMap.put(product.getName(), product));
	}

	public Optional<Product> findByName(String name) {
		return Optional.ofNullable(productMap.get(name));
	}

	public List<Product> findAll() {
		return new ArrayList<>(productMap.values());
	}
}
