package vendingmachine.utils;

public class ValidateUtils {

	private static final int ZERO = 0;
	private static final int DIVIDE_NUMBER = 10;
	private static final String ERROR_INVALID_COIN = "유효하지 않은 금액입니다.";
	private static final String ERROR_NOT_NUMBER = "금액은 숫자만 입력해야합니다.";

	public static void validateInputCoin(String inputCoin) {
		isDigit(inputCoin);
		isValidCoin(Integer.parseInt(inputCoin));
	}

	private static void isValidCoin(int coin) {
		if (coin == ZERO) {
			throw new IllegalArgumentException(ERROR_INVALID_COIN);
		}
		if (coin % DIVIDE_NUMBER != ZERO) {
			throw new IllegalArgumentException(ERROR_INVALID_COIN);
		}
	}

	private static void isDigit(String inputCoin) {
		for (char number : inputCoin.toCharArray()) {
			if (!Character.isDigit(number)) {
				throw new IllegalArgumentException(ERROR_NOT_NUMBER);
			}
		}
	}
}
