package vendingmachine.domain.machine.product.storage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Optional;
import vendingmachine.domain.machine.product.Product;
import vendingmachine.domain.user.Balance;
import vendingmachine.exception.ProductNotFoundMessageException;

public class ProductStorageImpl implements ProductStorage {

	private Map<String, Product> productMap = new HashMap<>();

	@Override
	public void save(List<Product> products) {
		for (Product product : products) {
			String productName = product.getName();
			productMap.put(productName, product);
		}
	}

	@Override
	public Product findOne(String productName) {
		return Optional.ofNullable(productMap.get(productName))
			.orElseThrow(ProductNotFoundMessageException::new);
	}

	@Override
	public boolean isAllSoldOut() {
		return productMap.values().stream()
			.allMatch(Product::isSoldOut);
	}

	@Override
	public boolean isPossibleToUseWith(Balance balance) {
		return productMap.values().stream()
			.filter(Product::isNotSoldOut)
			.anyMatch(product -> product.isNotEnoughMoney(balance.getMoney()));
	}

}
