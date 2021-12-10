package vendingmachine.utils;

public class Validator {

	public static void validateMoney(int money) {
		if (money <= 0) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_ERROR_MESSAGE);
		}
	}
}
