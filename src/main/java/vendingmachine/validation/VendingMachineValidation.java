package vendingmachine.validation;

import vendingmachine.model.Product;
import vendingmachine.model.ProductList;

public class VendingMachineValidation {

	public static Product existProduct(ProductList productList, String name) {
		Product product = productList.findByName(name);
		if (product == null) {
			throw new IllegalArgumentException("해당 상품이 존재하지 않습니다.");
		}
		return product;
	}
}
