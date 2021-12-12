package vendingmachine.util;

import java.util.Map;

import vendingmachine.constants.ErrorMessage;
import vendingmachine.constants.Rule;
import vendingmachine.model.Product;

public class ProductException {
	public static void checkProductInfoSize(String[] productInfo) {

		if (productInfo.length != Rule.PRODUCT_INFO_SIZE) {
			throw new IllegalArgumentException(ErrorMessage.ARRAY_SIZE_MESSAGE);
		}

	}

	public static void checkProductReDuplication(Map<String, Product> menuList, String productName) {

		if (menuList.containsKey(productName)) {
			menuList.clear();
			throw new IllegalArgumentException(ErrorMessage.REDUPLICATION_NAME_MESSAGE);
		}

	}

	public static void checkInsertedProductLineIsRight(String insertedProductLine) {
		try {
			insertedProductLine = StringException.checkStringException(insertedProductLine);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(ErrorMessage.INSERTED_PRODUCT_IS_WRONG);
		}
	}

}
