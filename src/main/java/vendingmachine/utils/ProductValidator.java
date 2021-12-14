package vendingmachine.utils;

import static vendingmachine.utils.ExceptionMessage.*;

public class ProductValidator {
	public static final int CAN_DIVISIBLE_COIN_STANDARD = 10;
	public static final int ZERO = 0;

	public static void validateProductPrice(int productPrice) {
		if (productPrice % CAN_DIVISIBLE_COIN_STANDARD != ZERO) {
			throw new IllegalArgumentException(ERROR_CONDITION_PRODUCT_PRICE);
		}
	}
}
