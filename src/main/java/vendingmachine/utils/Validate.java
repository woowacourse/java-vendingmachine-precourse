package vendingmachine.utils;

import static vendingmachine.utils.Constant.*;

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
}
