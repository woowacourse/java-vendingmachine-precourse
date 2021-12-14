package vendingmachine.domain.machine.product.storage;

import java.util.List;

import vendingmachine.domain.machine.product.Product;
import vendingmachine.domain.user.Balance;

public interface ProductStorage {

	void save(List<Product> products);

	Product findOne(String productName);

	boolean isAllSoldOut();

	boolean isPossibleToUseWith(Balance balance);

}
