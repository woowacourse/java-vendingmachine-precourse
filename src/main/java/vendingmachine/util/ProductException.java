package vendingmachine.util;

import vendingmachine.constants.ErrorMessage;

public class ProductException {
	public static void ProductInfoSize(String[] productInfo) {

		if (productInfo.length != 3) {
			throw new IllegalArgumentException(ErrorMessage.ARRAY_SIZE_MESSAGE);
		}

	}
	
}
