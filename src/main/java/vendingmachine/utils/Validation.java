package vendingmachine.utils;

public class Validation {

	public static void isHoldingAmount(String input) {
		int holdingAmount;

		try {
			holdingAmount = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessage.COMMON + ErrorMessage.HOLDING_AMOUNT_NUM);
		}

		if (holdingAmount < Constant.HOLDING_AMOUNT_MIN) {
			throw new IllegalArgumentException(ErrorMessage.COMMON + ErrorMessage.HOLDING_AMOUNT_MIN);
		}

		if (holdingAmount > Constant.HOLDING_AMOUNT_MAX) {
			throw new IllegalArgumentException(ErrorMessage.COMMON + ErrorMessage.HOLDING_AMOUNT_MAX);
		}

		if (holdingAmount % Constant.HOLDING_AMOUNT_DIVIDE != Constant.HOLDING_AMOUNT_REMAINDER) {
			throw new IllegalArgumentException(ErrorMessage.COMMON + ErrorMessage.HOLDING_AMOUNT_DIVIDE);
		}
	}

}
