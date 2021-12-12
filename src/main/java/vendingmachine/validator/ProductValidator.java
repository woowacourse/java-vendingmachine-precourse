package vendingmachine.validator;

import static vendingmachine.constant.ErrorMessage.*;
import static vendingmachine.constant.SystemMessage.*;

public class ProductValidator {
	public static void checkProduct(String inputProducts) {
		if (isNotMatchedRegex(inputProducts)) {
			throw new IllegalArgumentException(PRODUCT_IS_NOT_MATCHED_REGEX_ERROR_MESSAGE);
		}
	}

	private static boolean isNotMatchedRegex(String inputProducts) {
		return !inputProducts.matches(PRODUCT_REGEX);
	}

	public static void checkProductName(String inputName) {
		if (isBlankName(inputName)) {
			throw new IllegalArgumentException(BLANK_NAME_ERROR_MESSAGE);
		}
	}

	private static boolean isBlankName(String inputName) {
		return inputName.trim().length() == 0;
	}

	public static void checkProductStock(int inputStocks) {
		if (inputStocks <= 0) {
			throw new IllegalArgumentException(OUT_OF_STOCK_ERROR_MESSAGE);
		}
	}
}
