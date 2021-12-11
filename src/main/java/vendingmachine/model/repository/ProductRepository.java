package vendingmachine.model.repository;

import java.util.ArrayList;

import vendingmachine.model.Product;

public class ProductRepository {

	// Singleton instance of ProductRepository class
	public static ProductRepository instance = new ProductRepository();

	private ArrayList<Product> productRepository;

	private ProductRepository() {
		this.productRepository = new ArrayList<>();
	}

	public ArrayList<Product> getProductRepository() {
		return productRepository;
	}
}
