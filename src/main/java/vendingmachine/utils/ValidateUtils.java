package vendingmachine.utils;

import vendingmachine.constant.Constant;
import vendingmachine.constant.Message;

public class ValidateUtils {

	public static void validateInputCoin(String inputCoin) {
		if (!isDigit(inputCoin)) {
			throw new IllegalArgumentException(Message.ERROR_NOT_NUMBER);
		}
		if (!isValidCoin(Integer.parseInt(inputCoin))) {
			throw new IllegalArgumentException(Message.ERROR_INVALID_COIN);
		}
	}

	public static boolean isValidInputType(String product) {
		return product.charAt(Constant.ZERO) == Constant.OPEN_BRACKET
			&& product.charAt(product.length() - 1) == Constant.CLOSE_BRACKET
			&& product.split(Constant.COMMA).length == Constant.PRODUCT_INFORMATION_LENGTH;
	}

	private static boolean isValidCoin(int coin) {
		return coin != Constant.ZERO && coin % Constant.DIVIDE_NUMBER == Constant.ZERO;
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
		return productPrice >= Constant.MIN_PRODUCT_PRICE && productPrice % Constant.DIVIDE_NUMBER == Constant.ZERO;
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
