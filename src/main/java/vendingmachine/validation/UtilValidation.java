package vendingmachine.validation;

import vendingmachine.constant.Constants;

public class UtilValidation {

	public static void isNumber(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException numberFormatException) {
			throw (new IllegalArgumentException("보유 금액은 숫자여야 합니다."));
		}
	}

	public static void isNaturalNumber(int number) {
		if (!(number > 0)) {
			throw (new IllegalArgumentException("입력은 자연수여야 합니다."));
		}
	}

	public static void canDivideMinCoin(int number) {
		if (number % Constants.MIN_COIN != 0) {
			throw (new IllegalArgumentException("금액은 "+ Constants.MIN_COIN +"으로 나누어 떨어져야 합니다."));
		}
	}

}
