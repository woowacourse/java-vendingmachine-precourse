package vendingmachine;

import static vendingmachine.Error.*;

public class Validator {
	private static final int ZERO = 0;
	private static final int MONEY_UNIT = 10;

	public static void validateNumber(String str) {
		int number;
		try {
			number = Integer.parseInt(str);
		} catch (Exception e) {
			error(ONLY_NUMBER);
		}
	}

	public static void validateOverZero(String str) {
		int number = Integer.parseInt(str);
		if (number < ZERO) {
			error(OVER_ZERO);
		}
	}

	public static void validateDividedByTen(String str) {
		int number = Integer.parseInt(str);

		if (number % MONEY_UNIT != 0) {
			error(DIVIDED_BY_TEN);
		}
	}
}
