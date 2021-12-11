package vendingmachine.product;

import java.util.ArrayList;
import java.util.List;

public class ProductStorage {
	private static final String ERROR_NOT_FOUND = "해당 상품은 자판기에서 판매하지 않습니다.";

	List<Product> storage;

	public void storeProducts(String request, ProductMapper productMapper, ProductValidator productValidator) {
		storage = new ArrayList<>();
		for (String each : request.split(";")) {
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

	public boolean isSellable(int money) {
		for (Product each : storage) {
			if (each.isPurchasable(money)) {
				return true;
			}
		}
		return false;
	}

	public int sellProduct(String name) {
		return findProductByName(name).sell();
	}

	private Product findProductByName(String name) {
		return storage.stream().filter(each -> each.isSameName(name)).findFirst()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_NOT_FOUND));
	}
}
