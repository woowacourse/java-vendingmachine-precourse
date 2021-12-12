package vendingmachine.util;

import java.util.Map;

import vendingmachine.constants.ErrorMessage;
import vendingmachine.model.Product;

public class ProductException {
	public static void checkProductInfoSize(String[] productInfo) {

		if (productInfo.length != 3) {
			throw new IllegalArgumentException(ErrorMessage.ARRAY_SIZE_MESSAGE);
		}

	}

	public static void checkProductReDuplication(Map<String, Product> menuList, String productName) {

		if (menuList.containsKey(productName)) {
			menuList.clear();
			throw new IllegalArgumentException(ErrorMessage.REDUPLICATION_NAME_MESSAGE);
		}

	}

}
