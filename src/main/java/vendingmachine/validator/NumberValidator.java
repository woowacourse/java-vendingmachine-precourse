package vendingmachine.validator;

public class NumberValidator {
	static final String MSG_NOT_INTEGER_ERROR = "[ERROR] 정수를 입력해야 한다.";
	static final String MSG_LESS_THAN_ZERO_ERROR = "[ERROR] 0보다 크거나 같아야 한다.";
	static final String MSG_LESS_THAN_PRICE_LIMIT_ERROR = "[ERROR] 100원 이상이어야 한다.";
	static final int LOW_LIMIT_OF_PRICE = 100;

	static public void isInteger(String number) {
		try {
			Integer.parseInt(number.trim());
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException(MSG_NOT_INTEGER_ERROR);
		}
	}

	static public void isGreaterThanOrEqualToZero(int number) {
		if (number < 0) {
			throw new IllegalArgumentException(MSG_LESS_THAN_ZERO_ERROR);
		}
	}

	static public void checkLowLimitOfPrice(int number) {
		if (number < LOW_LIMIT_OF_PRICE) {
			throw new IllegalArgumentException(MSG_LESS_THAN_PRICE_LIMIT_ERROR);
		}
	}
}
