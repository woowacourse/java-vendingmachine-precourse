package vendingmachine.repository;

import vendingmachine.domain.ProductSet;

public class ProductRepository {

	private static ProductSet productSet = new ProductSet();

	public ProductRepository() {
	}

	public ProductRepository(ProductSet otherProductSet) {
		productSet = otherProductSet;
	}

	public String save(ProductSet newProductSet) {
		productSet = newProductSet;
		return productSet.toString();
	}

}
