package vendingmachine.repository;

import vendingmachine.domain.Name;
import vendingmachine.domain.Price;
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

	public Price purchase(Name name) {
		return productSet.purchase(name);
	}

	public ProductSet get() {
		return productSet;
	}
}
