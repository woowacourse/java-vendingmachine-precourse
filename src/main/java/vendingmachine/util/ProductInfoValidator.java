package vendingmachine.util;

import vendingmachine.model.Product;

public class ProductInfoValidator {
	public static final boolean aboveMinimumPrice(String input) {
		int price = Integer.parseInt(input);
		if (price < Product.MINIMUM_PRICE) {
			return false;
		}
		return true;
	}
}
