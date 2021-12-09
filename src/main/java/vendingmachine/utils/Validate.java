package vendingmachine.utils;

import static vendingmachine.utils.Constant.*;

public class Validate {
	public static void validateInputHoldingAmountMoney(String input) {
		try {
			Integer.parseInt(input);
		} catch (Exception exception) {
			throw new IllegalArgumentException(ERROR_MESSAGE + "금액은 숫자여야 합니다.");
		}
	}
}
