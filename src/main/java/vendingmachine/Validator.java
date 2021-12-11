package vendingmachine;

public class Validator {

	private static final String ERROR_MSG_NOT_NUMERIC = "[ERROR] 숫자만 입력할 수 있습니다.";
	private static final String ERROR_MSG_LESS_THAN_MIN = "[ERROR] 입력 값은 10보다 커야합니다.";
	private static final String ERROR_MSG_MULTIPLE_OF_TEN = "[ERROR] 입력 값은 10으로 나누어떨어져야 합니다.";
	private static final int MINIMUM_OF_COIN_AMOUNT = 10;
	private static final int ZERO = 0;

	public static void isNumeric(String input) {
		try {
			Integer.parseInt(input);
		} catch (Exception e) {
			throw new IllegalArgumentException(ERROR_MSG_NOT_NUMERIC);
		}
	}

	public static void coinMinimumCheck(String input) {
		if (Integer.parseInt(input) < MINIMUM_OF_COIN_AMOUNT) {
			throw new IllegalArgumentException(ERROR_MSG_LESS_THAN_MIN);
		}
	}

	public static void multipleOfTen(String input) {
		if (Integer.parseInt(input) % MINIMUM_OF_COIN_AMOUNT > ZERO) {
			throw new IllegalArgumentException(ERROR_MSG_MULTIPLE_OF_TEN);
		}
	}
}
