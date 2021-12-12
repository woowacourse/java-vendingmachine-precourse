package vendingmachine.product;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.billing.Money;

public class ProductStorage {
	private static final String ERROR_NOT_FOUND = "해당 상품은 자판기에서 판매하지 않습니다.";
	private static final String MULTIPLE_DELIMITER = ";";
	
	List<Product> storage;

	public void storeProducts(String inputProducts, ProductMapper productMapper, ProductValidator productValidator) {
		storage = new ArrayList<>();
		for (String each : inputProducts.split(MULTIPLE_DELIMITER)) {
			Product product = productMapper.mapFrom(each, productValidator);
			isAlreadyExist(product);
			storage.add(product);
		}
	}

	private void isAlreadyExist(Product product) {
		for (Product each : storage) {
			each.isDuplicate(product);
		}
	}

	public boolean isSellable(Money money) {
		for (Product each : storage) {
			if (each.isEnoughMoney(money) && each.isRemainStock()) {
				return true;
			}
		}
		return false;
	}

	public Product findProductByName(String name) {
		return storage.stream().filter(each -> each.isSameName(name)).findFirst()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_NOT_FOUND));
	}
}
