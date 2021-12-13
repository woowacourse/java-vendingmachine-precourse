package vendingmachine.validation;

import vendingmachine.constant.Constants;
import vendingmachine.model.Coin;

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
		if (number % Coin.getMin() != 0) {
			throw (new IllegalArgumentException("금액은 "+ Coin.getMin() +"으로 나누어 떨어져야 합니다."));
		}
	}

	public static void isUpperNumber(int target, int number) {
		if (target > number) {
			throw (new IllegalArgumentException("값이 " + target + "보다 작습니다."));
		}
	}

}
