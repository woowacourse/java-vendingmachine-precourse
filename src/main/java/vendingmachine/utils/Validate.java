package vendingmachine.utils;


import static vendingmachine.utils.Constant.*;

import java.util.List;
import java.util.regex.Pattern;

public class Validate {

	public static void validateInputHoldingAmountMoney(String input) {
		validateInputStringToInteger(input);
		validateIsNotNegative(input);
	}

	private static void validateInputStringToInteger(String input) {
		try {
			Integer.parseInt(input);
		} catch (Exception exception) {
			throw new IllegalArgumentException(ERROR_MESSAGE + "금액은 숫자여야 합니다.");
		}
	}

	private static void validateIsNotNegative(String input) {
		if (Integer.parseInt(input) < 0) {
			throw new IllegalArgumentException(ERROR_MESSAGE + "금액은 음수일 수 없습니다.");
		}
	}

	public static void validateInputProductList(List<String> productList) {
		for (String product: productList) {
			if (!Pattern.matches(REGEX_OF_PRODUCT_INPUT, product)) {
				throw new IllegalArgumentException(ERROR_MESSAGE + "입력 값 형식이 올바르지 않습니다.");
			}
		}
	}
}
