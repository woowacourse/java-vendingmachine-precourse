package vendingmachine;

public class InputException {
	private static final String IS_INTEGER_ERROR_MSG = "[ERROR] 금액은 숫자여야 합니다.";
	private static final String IS_POSITIVE_INTEGER_ERROR_MSG = "[ERROR] 금액은 0보다 커야 합니다.";
	private static final String IS_MULTIPLICATION_OF_TEN_ERROR_MSG = "[ERROR] 금액은 10으로 나누어 떨어져야 합니다.";

	public static void checkAmount(String amount) {
		isInteger(amount);
		isPositiveInteger(amount);
		isMultiplicationOfTen(amount);
	}

	public static void isInteger(String amount) {
		try {
			Integer.parseInt(amount);
		} catch (Exception e) {
			throw new IllegalArgumentException(IS_INTEGER_ERROR_MSG);
		}
	}

	public static void isPositiveInteger(String amount) {
		if (Integer.parseInt(amount) <= 0) {
			throw new IllegalArgumentException(IS_POSITIVE_INTEGER_ERROR_MSG);
		}
	}

	public static void isMultiplicationOfTen(String amount) {
		if (Integer.parseInt(amount) % 10 != 0) {
			throw new IllegalArgumentException(IS_MULTIPLICATION_OF_TEN_ERROR_MSG);
		}
	}
}
