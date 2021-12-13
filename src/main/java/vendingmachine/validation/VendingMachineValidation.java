package vendingmachine.validation;

import vendingmachine.model.Product;
import vendingmachine.model.ProductList;
import vendingmachine.model.User;

public class VendingMachineValidation {

	public static Product existProduct(ProductList productList, String name) {
		Product product = productList.findByName(name);
		if (product == null) {
			throw new IllegalArgumentException("해당 상품이 존재하지 않습니다.");
		}
		return product;
	}

	public static Product buyProduct(ProductList productList, String name, User user) {
		Product product = existProduct(productList, name);
		if (!product.isRemain()) {
			throw new IllegalArgumentException("상품의 재고가 부족합니다.");
		}
		if (!user.canBuy(product.getPrice())) {
			throw new IllegalArgumentException("사용자의 잔고가 부족합니다.");
		}
		return product;
	}
	
}
