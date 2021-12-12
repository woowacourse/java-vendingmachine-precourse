package vendingmachine.util;

import java.util.List;
import java.util.Map;

import vendingmachine.constants.ErrorMessage;
import vendingmachine.model.Product;

public class ProductException {
	public static void checkProductInfoSize(String[] productInfo) {

		if (productInfo.length != 3) {
			throw new IllegalArgumentException(ErrorMessage.ARRAY_SIZE_MESSAGE);
		}

	}

	public static void checkProductReDuplication(List<Product> menuList, String productName,
		Map<String, Integer> nameList, int idx) {

		if (nameList.containsKey(productName)) {
			menuList.clear();
			nameList.clear();
			throw new IllegalArgumentException(ErrorMessage.REDUPLICATION_NAME_MESSAGE);
		}

		nameList.put(productName, idx);
	}

}
