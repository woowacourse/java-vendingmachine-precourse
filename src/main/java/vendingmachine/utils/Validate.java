package vendingmachine.utils;


import static vendingmachine.utils.ExceptionMessage.*;

import java.util.List;
import java.util.regex.Pattern;

public class Validate {
	public static final String REGEX_OF_PRODUCT_INPUT = "\\[.+,\\d{3,},\\d+]";

	public static void validateInputHoldingAmountMoney(String input) {
		validateInputStringToInteger(input);
		validateIsNotNegative(input);
	}

	private static void validateInputStringToInteger(String input) {
		try {
			Integer.parseInt(input);
		} catch (Exception exception) {
			throw new IllegalArgumentException();
		}
	}

	private static void validateIsNotNegative(String input) {
		if (Integer.parseInt(input) < 0) {
			throw new IllegalArgumentException(ERROR_ONLY_CAN_INPUT_NUMBER);
		}
	}

	public static void validateInputProductList(List<String> productList) {
		for (String product: productList) {
			if (!Pattern.matches(REGEX_OF_PRODUCT_INPUT, product)) {
				throw new IllegalArgumentException(ERROR_NOT_CORRECT_REGEX_INPUT);
			}
		}
	}

	public static void validateInputUserAmount(String input) {
		validateInputStringToInteger(input);
	}
}
