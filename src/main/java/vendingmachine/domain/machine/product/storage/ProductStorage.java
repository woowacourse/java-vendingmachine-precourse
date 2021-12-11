package vendingmachine.domain.machine.product.storage;

import vendingmachine.domain.machine.product.Product;

public interface ProductStorage {

	void save(Product product);

	Product findOne(String productName);

	boolean isAllSoldOut();

	int getLowestPriceBetweenNotSoldOut();

}
