package vendingmachine;

import static vendingmachine.Error.*;
import static vendingmachine.service.VendingMachineManagement.*;

import vendingmachine.domain.VendingMachine;

import java.util.List;

public class Validator {
	private static final int ZERO = 0;
	private static final int MONEY_UNIT = 10;

	private static final int MINIMUM_OF_PRODUCT_PRICE = 100;

	public static void validateNumber(String str) {
		int number;
		try {
			number = Integer.parseInt(str);
		} catch (Exception e) {
			error(ONLY_NUMBER);
		}
	}

	public static void validateOverZero(String str) {
		int number = Integer.parseInt(str);
		if (number < ZERO) {
			error(OVER_ZERO);
		}
	}

	public static void validateDividedByTen(String str) {
		int number = Integer.parseInt(str);

		if (number % MONEY_UNIT != 0) {
			error(DIVIDED_BY_TEN);
		}
	}

	public static void validateEmpty(String str) {
		if (str.equals(EMPTY)) {
			error(PRODUCT_EMPTY);
		}
	}

	public static void validateCoverTextOfProducts(String stringOfProducts) {
		String[] products = splitStringOfProducts(stringOfProducts);

		for (String stringOfProduct : products) {
			if (!stringOfProduct.substring(0, 1).equals(COVER_PRODUCT_START)) {
				error(PRODUCTS_COVER_TEXT);
			}
			if (!stringOfProduct.substring(stringOfProduct.length() - 1).equals(COVER_PRODUCT_END)) {
				error(PRODUCTS_COVER_TEXT);
			}
		}
	}

	private static String[] splitStringOfProducts(String stringOfProducts) {
		return stringOfProducts.split(SPLIT_PRODUCTS);
	}

	public static void validateSplitTextOfProduct(String stringOfProducts) {
		String[] products = splitStringOfProducts(stringOfProducts);

		for (String stringOfProduct : products) {
			if (stringOfProduct.split(SPLIT_PRODUCT).length != PRODUCT_INFO_COUNT) {
				error(PRODUCT_SPLIT_TEXT);
			}
		}
	}

	public static void validateProductNameEmpty(String str) {
		if (str.equals(EMPTY)) {
			error(PRODUCT_NAME_EMPTY);
		}
	}

	public static void validateDuplicatedProductName(String str, VendingMachine vendingMachine, List<String> insertProductName) {
		if (vendingMachine.isDuplicatedName(str)) {
			error(PRODUCT_NAME_DUPLICATE);
		}
		if (insertProductName.contains(str)) {
			error(PRODUCT_NAME_DUPLICATE);
		}
	}

	public static void validateProductPriceNumber(String str) {
		int number;
		try {
			number = Integer.parseInt(str);
		} catch (Exception e) {
			error(PRODUCT_PRICE_ONLY_NUMBER);
		}
	}

	public static void validateProductPriceMinimum(String str) {
		int number = Integer.parseInt(str);
		if (number < MINIMUM_OF_PRODUCT_PRICE) {
			error(PRODUCT_PRICE_MINIMUM);
		}
	}

	public static void validateProductPriceDividedByTen(String str) {
		int number = Integer.parseInt(str);

		if (number % MONEY_UNIT != 0) {
			error(PRODUCT_PRICE_DIVIDED_BY_TEN);
		}
	}

	public static void validateProductQuantityNumber(String str) {
		int number;
		try {
			number = Integer.parseInt(str);
		} catch (Exception e) {
			error(PRODUCT_QUANTITY_ONLY_NUMBER);
		}
	}

	public static void validateProductQuantityOverZero(String str) {
		int number = Integer.parseInt(str);
		if (number < ZERO) {
			error(PRODUCT_QUANTITY_OVER_ZERO);
		}
	}
}
