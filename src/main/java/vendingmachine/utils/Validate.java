package vendingmachine.utils;


import static vendingmachine.utils.ExceptionMessage.*;

import java.util.List;
import java.util.regex.Pattern;

public class Validate {
	public static final String REGEX_OF_PRODUCT_INPUT = "\\[.+,\\d{3,},\\d+]";
	public static final int MINIMUM_PRODUCT_PRICE = 100;
	public static final int CAN_DIVISIBLE_COIN_STANDARD = 10;

	public static void validateInputHoldingAmountMoney(String input) {
		validateInputStringToInteger(input);
		validateIsNotNegative(input);
	}

	private static void validateInputStringToInteger(String input) {
		try {
			Integer.parseInt(input);
		} catch (Exception exception) {
			throw new IllegalArgumentException(ERROR_INPUT_HOLDING_AMOUNT_MONEY);
		}
	}

	private static void validateIsNotNegative(String input) {
		if (Integer.parseInt(input) < 0) {
			throw new IllegalArgumentException(ERROR_ONLY_CAN_INPUT_POSITIVE_MONEY);
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
		validateInputUserAmountIsPositive(input);
	}

	private static void validateInputUserAmountIsPositive(String input) {
		if (Integer.parseInt(input) < 0) {
			throw new IllegalArgumentException(ERROR_ONLY_CAN_INPUT_POSITIVE_MONEY);
		}
	}

	public static void validateProductPrice(int productPrice) {
		if (productPrice < MINIMUM_PRODUCT_PRICE) {
			throw new IllegalArgumentException(ERROR_MINIMUM_CONDITION_PRODUCT_PRICE);
		}
		if (productPrice % CAN_DIVISIBLE_COIN_STANDARD != 0) {
			throw new IllegalArgumentException(ERROR_CONDITION_PRODUCT_PRICE);
		}
	}
}
