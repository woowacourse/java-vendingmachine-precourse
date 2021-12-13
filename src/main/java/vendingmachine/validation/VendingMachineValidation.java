package vendingmachine.validation;

import static vendingmachine.constant.ErrorMessage.*;

import vendingmachine.model.Product;
import vendingmachine.model.ProductList;
import vendingmachine.model.User;

public class VendingMachineValidation {

	public static Product existProduct(ProductList productList, String name) {
		Product product = productList.findByName(name);
		if (product == null) {
			throw new IllegalArgumentException(ERROR_NOT_EXIST);
		}
		return product;
	}

	public static Product buyProduct(ProductList productList, String name, User user) {
		Product product = existProduct(productList, name);
		if (!product.isRemain()) {
			throw new IllegalArgumentException(ERROR_NOT_STOCK);
		}
		if (!user.canBuy(product.getPrice())) {
			throw new IllegalArgumentException(ERROR_REMAIN_BALANCE);
		}
		return product;
	}
	
}
