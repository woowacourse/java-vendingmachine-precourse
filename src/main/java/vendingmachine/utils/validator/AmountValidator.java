package vendingmachine.utils.validator;

import static vendingmachine.utils.Error.*;

public class AmountValidator {

	private static final int PRICE = 1;
	private static final int LOWEST_AMOUNT = 100;

	public static int validateAmount(String amount, int condition) {
		try {
			int processedAmount = Integer.parseInt(amount);
			validatePositive(processedAmount);
			validateMinimum(processedAmount, condition);
			validateDivisible(processedAmount);

			return processedAmount;
		} catch (NumberFormatException e) {
			throw new NumberFormatException(NUMBER_FORMAT_ERROR);
		}
	}

	private static void validatePositive(int amount) {
		if (amount < 1) {
			throw new IllegalArgumentException(AMOUNT_NOT_POSITIVE_ERROR);
		}
	}

	private static void validateMinimum(int amount, int condition) {
		if (condition == PRICE && amount < LOWEST_AMOUNT) {
			throw new IllegalArgumentException(AMOUNT_MINIMUM_ERROR);
		}
	}

	private static void validateDivisible(int amount) {
		if (amount % 10 != 0) {
			throw new IllegalArgumentException(AMOUNT_NOT_DIVIDE_ERROR);
		}
	}
}
