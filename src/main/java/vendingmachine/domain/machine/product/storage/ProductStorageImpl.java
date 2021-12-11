package vendingmachine.domain.machine.product.storage;

import java.util.HashMap;
import java.util.Map;

import java.util.Optional;
import vendingmachine.domain.machine.product.Product;
import vendingmachine.exception.ProductAlreadyExistMessageException;
import vendingmachine.exception.ProductNotFoundMessageException;

public class ProductStorageImpl implements ProductStorage {

	private Map<String, Product> productMap = new HashMap<>();

	@Override
	public void save(Product product) {
		String productName = product.getName();
		checkProductAlreadyExist(productName);
		productMap.put(productName, product);
	}

	private void checkProductAlreadyExist(String productName) {
		if (productMap.containsKey(productName)) {
			throw new ProductAlreadyExistMessageException();
		}
	}

	@Override
	public Product findOne(String productName) {
		return Optional.ofNullable(productMap.get(productName))
			.orElseThrow(ProductNotFoundMessageException::new);
	}

	@Override
	public boolean isAllSoldOut() {
		return false;
	}

	@Override
	public int getLowestPriceBetweenNotSoldOut() {
		return 0;
	}
}
