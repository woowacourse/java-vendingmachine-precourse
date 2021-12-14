package vendingmachine.validator;

public class NumberValidator {
	static final String MSG_NOT_INTEGER_ERROR = "[ERROR] 정수를 입력해야 한다.";
	static final String MSG_LESS_THAN_ZERO_ERROR = "[ERROR] 0보다 크거나 같아야 한다.";
	static final String MSG_LESS_THAN_LEAST_PRICE_ERROR = "[ERROR] 100원 이상이어야 한다.";
	static final String MSG_NOT_DIVISIBLE_ERROR = "[ERROR] 10으로 나누어 떨어져야 한다.";
	static final int LEAST_PRICE = 100;
	static final int MINIMUM_UNIT_OF_COIN = 10;

	public static void isInteger(String number) {
		try {
			Integer.parseInt(number.trim());
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException(MSG_NOT_INTEGER_ERROR);
		}
	}

	public static void isGreaterThanOrEqualToZero(int number) {
		if (number < 0) {
			throw new IllegalArgumentException(MSG_LESS_THAN_ZERO_ERROR);
		}
	}

	public static void isGreaterThanOrEqualToLeastPrice(int number) {
		if (number < LEAST_PRICE) {
			throw new IllegalArgumentException(MSG_LESS_THAN_LEAST_PRICE_ERROR);
		}
	}

	public static void isDivisibleByMinimumUnit(int number) {
		if (number % MINIMUM_UNIT_OF_COIN != 0) {
			throw new IllegalArgumentException(MSG_NOT_DIVISIBLE_ERROR);
		}
	}
}
