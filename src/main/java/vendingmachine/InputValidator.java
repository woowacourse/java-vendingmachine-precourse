package vendingmachine;

import java.util.regex.Pattern;

import vendingmachine.utils.ErrorMessage;

public class InputValidator {
	private static final String SPLITTER_OF_PRODUCT = ";";
	private static final String SPLITTER_OF_PRODUCT_INFO = ",";
	private static final String REGEX_PATTERN_OF_PRODUCT_INPUT = "\\[.+,[0-9]+,[0-9]+]";
	private static final int PRODUCT_COST_INDEX = 1;
	private static final int NUMBER_OF_PRODUCT_INDEX = 2;
	private static final int UNIT_OF_MONEY = 10;
	private static final int MINIMUM_AMOUNT_OF_PRODUCT = 100;
	private static final int ZERO = 0;

	public static void checkIsValidHoldingAmountInput(String amount) {
		for (int i = 0; i < amount.length(); i++) {
			if (!Character.isDigit(amount.charAt(i))) {
				throw new IllegalArgumentException(ErrorMessage.INVALID_TYPE_OF_HOLDING_AMOUNT_MESSAGE);
			}
		}
		if (Integer.parseInt(amount) % UNIT_OF_MONEY > ZERO) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE_OF_HOLDING_AMOUNT_MESSAGE);
		}
	}

	public static void checkIsValidProductsInput(String products) {
		String[] productArray = products.split(SPLITTER_OF_PRODUCT);
		if (productArray.length == ZERO) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_OF_PRODUCT_MESSAGE);
		}
		for (String productInfo : productArray) {
			if (!Pattern.matches(REGEX_PATTERN_OF_PRODUCT_INPUT, productInfo)) {
				throw new IllegalArgumentException(ErrorMessage.INVALID_PATTERN_OF_PRODUCT_MESSAGE);
			}
			checkIsValidProductInput(productInfo.substring(1, productInfo.length() - 1));
		}
	}

	private static void checkIsValidProductInput(String productInfo) {
		String[] info = productInfo.split(SPLITTER_OF_PRODUCT_INFO);
		int productCost = Integer.parseInt(info[PRODUCT_COST_INDEX]);
		if (productCost % UNIT_OF_MONEY > ZERO) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_UNIT_OF_PRODUCT_AMOUNT_MESSAGE);
		}
		if (productCost < MINIMUM_AMOUNT_OF_PRODUCT) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE_OF_PRODUCT_AMOUNT_MESSAGE);
		}
		int numberOfProduct = Integer.parseInt(info[NUMBER_OF_PRODUCT_INDEX]);
		if (numberOfProduct <= ZERO) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_OF_PRODUCT_AMOUNT_MESSAGE);
		}
	}

	public static void checkIsValidInputAmountInput(String inputAmount) {
		for (int i = 0; i < inputAmount.length(); i++) {
			if(!Character.isDigit(inputAmount.charAt(i))) {
				throw new IllegalArgumentException(ErrorMessage.INVALID_TYPE_OF_INPUT_AMOUNT_MESSAGE);
			}
		}
	}
}
