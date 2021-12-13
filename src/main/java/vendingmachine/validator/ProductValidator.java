package vendingmachine.validator;

import static constants.ProductConstants.*;
import static constants.VendingMachineConstants.*;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class ProductValidator {
	public static List<String> checkProduct(String input) {
		checkIsEmpty(input);
		isMatchRegex(input);
		String inputContent = input.substring(SUBSTRING_IDX, input.length() - SUBSTRING_IDX);

		List<String> productInfo = Arrays.asList(inputContent.split(PRODUCT_DELIMITER));
		MoneyValidator.checkMoney(productInfo.get(PRICE_IDX));
		checkAmount(productInfo.get(AMOUNT_IDX));
		return productInfo;
	}

	private static void checkIsEmpty(String input) {
		if (input.isEmpty()) {
			throw new IllegalArgumentException(PRODUCT_EMPTY_ERROR);
		}
	}

	private static void isMatchRegex(String inputContent) {
		if (!Pattern.matches(REGEX, inputContent)) {
			throw new IllegalArgumentException(PRODUCT_FORMAT_ERROR);
		}
	}

	private static void checkAmount(String amount) {
		if (Integer.parseInt(amount) <= 0) {
			throw new IllegalArgumentException(PRODUCT_AMOUNT_ERROR);
		}
	}
}
