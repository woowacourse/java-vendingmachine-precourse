package vendingmachine.domain.machine.product.storage;

import vendingmachine.domain.machine.product.Product;
import vendingmachine.domain.user.Balance;

public interface ProductStorage {

	void save(Product product);

	Product findOne(String productName);

	boolean isAllSoldOut();

	boolean isPossibleToUseWith(Balance balance);

}
