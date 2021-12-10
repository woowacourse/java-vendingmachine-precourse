package vendingmachine.util;

import java.util.Set;

import vendingmachine.constants.ErrorMessage;

public class ProductException {
	public static void checkProductInfoSize(String[] productInfo) {

		if (productInfo.length != 3) {
			throw new IllegalArgumentException(ErrorMessage.ARRAY_SIZE_MESSAGE);
		}

	}

	public static void checkProductReDuplication(String productName, Set<String> nameList) {

		if (nameList.contains(productName)) {
			throw new IllegalArgumentException(ErrorMessage.REDUPLICATION_NAME_MESSAGE);
		}

		nameList.add(productName);
	}

}
