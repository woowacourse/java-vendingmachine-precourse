package vendingmachine.utils;

public class ValidateUtils {

	private static final String ERROR_INVALID_COIN = "유효하지 않은 금액입니다.";
	private static final String ERROR_NOT_NUMBER = "숫자만 입력해야합니다.";
	private static final int ZERO = 0;
	private static final int DIVIDE_NUMBER = 10;
	private static final int MIN_PRODUCT_PRICE = 100;

	public static void validateInputCoin(String inputCoin) {
		if (!isDigit(inputCoin)) {
			throw new IllegalArgumentException(ERROR_NOT_NUMBER);
		}
		if (!isValidCoin(Integer.parseInt(inputCoin))) {
			throw new IllegalArgumentException(ERROR_INVALID_COIN);
		}
	}

	private static boolean isValidCoin(int coin) {
		return coin != ZERO && coin % DIVIDE_NUMBER == ZERO;
	}

	public static boolean isDigit(String inputCoin) {
		for (char number : inputCoin.toCharArray()) {
			if (!Character.isDigit(number)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isValidPrice(int productPrice) {
		return productPrice >= MIN_PRODUCT_PRICE && productPrice % DIVIDE_NUMBER == ZERO;
	}

	public static boolean isDigits(String... inputCoins) {
		for (String inputCoin : inputCoins) {
			if (!isDigit(inputCoin)) {
				return false;
			}
		}
		return true;
	}
}
