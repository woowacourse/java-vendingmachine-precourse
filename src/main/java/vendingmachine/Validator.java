package vendingmachine;

import java.util.List;
import java.util.regex.Pattern;
import vendingmachine.domain.VendingMachine;

import static vendingmachine.Error.*;
import static vendingmachine.service.VendingMachineManagement.*;

public class Validator {
	private static final int ZERO = 0;
	private static final int MONEY_UNIT = 10;

	private static final int MINIMUM_OF_PRODUCT_PRICE = 100;

	private static final String COVER_TEXT_OF_PRODUCT_PATTERN = COVER_PRODUCT_START_PATTERN + ".*" + COVER_PRODUCT_END_PATTERN;

	public static void validateNumber(String str, String errorMessage) {
		int number;
		try {
			number = Integer.parseInt(str);
		} catch (Exception e) {
			error(errorMessage);
		}
	}

	public static void validateOverZero(String str, String errorMessage) {
		int number = Integer.parseInt(str);
		if (number < ZERO) {
			error(errorMessage);
		}
	}

	public static void validateDividedByTen(String str, String errorMessage) {
		int number = Integer.parseInt(str);

		if (number % MONEY_UNIT != 0) {
			error(errorMessage);
		}
	}

	public static void validateEmpty(String str, String errorMessage) {
		if (str.equals(EMPTY)) {
			error(errorMessage);
		}
	}

	public static void validateCoverTextOfProducts(String stringOfProducts, String errorMessage) {
		String[] products = splitStringOfProducts(stringOfProducts);

		for (String stringOfProduct : products) {
			if (!Pattern.matches(COVER_TEXT_OF_PRODUCT_PATTERN, stringOfProduct)) {
				error(errorMessage);
			}
		}
	}

	private static String[] splitStringOfProducts(String stringOfProducts) {
		return stringOfProducts.split(SPLIT_PRODUCTS);
	}

	public static void validateSplitTextOfProduct(String stringOfProducts, String errorMessage) {
		String[] products = splitStringOfProducts(stringOfProducts);

		for (String stringOfProduct : products) {
			if (!Pattern.matches(SPLIT_PRODUCT_PATTERN, stringOfProduct)) {
				error(errorMessage);
			}
		}
	}

	public static void validateDuplicated(String str, VendingMachine vendingMachine, List<String> insertProductName, String errorMessage) {
		if (vendingMachine.isDuplicatedName(str)) {
			error(errorMessage);
		}
		if (insertProductName.contains(str)) {
			error(errorMessage);
		}
	}

	public static void validateProductPriceMinimum(String str, String errorMessage) {
		int number = Integer.parseInt(str);
		if (number < MINIMUM_OF_PRODUCT_PRICE) {
			error(errorMessage);
		}
	}
}
