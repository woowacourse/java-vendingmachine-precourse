package vendingmachine.validation;

import static vendingmachine.constant.ErrorMessage.*;

import vendingmachine.model.Coin;

public class UtilValidation {

	public static void isNumber(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException numberFormatException) {
			throw (new IllegalArgumentException(ERROR_BE_NUMBER));
		}
	}

	public static void isNaturalNumber(int number) {
		if (!(number > 0)) {
			throw (new IllegalArgumentException(ERROR_BE_NATURAL_NUMBER));
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
