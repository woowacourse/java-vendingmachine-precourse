package vendingmachine.domain.product;

import java.util.List;

import vendingmachine.exception.ProductIsNotExistedException;

public class ProductRepository {

	private final Products products;
	private final ProductFactory productFactory;

	public ProductRepository(Products products, ProductFactory productFactory){
		this.products = products;
		this.productFactory = productFactory;
	}

	public void save(String productName, int price, int ea){
		products.insert(productFactory.create(productName, price, ea));
	}

	public List<Product> findAll(){
		return products.getProductList();
	}

	public Product findByName(String name){
		return findAll()
			.stream()
			.filter(p -> p.getName().equalsIgnoreCase(name))
			.findFirst()
			.orElse(null);
	}

}
