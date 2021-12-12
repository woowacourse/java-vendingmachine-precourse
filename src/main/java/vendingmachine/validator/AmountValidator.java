package vendingmachine.validator;

import static vendingmachine.constant.ErrorMessage.*;

import vendingmachine.domain.Coin;

public class AmountValidator {
	public static void checkVendingMachineAmount(String inputAmount) {
		int amount = toInteger(inputAmount);
		if (isLessThanCertainCoinAmount(Coin.getSmallestCoinAmount(), amount)) {
			throw new IllegalArgumentException(
				String.format(LESS_THAN_CERTAIN_COIN_ERROR, Coin.getSmallestCoinAmount()));
		}
		if (isDivisibleBySmallestCoinAmount(amount)) {
			throw new IllegalArgumentException(
				String.format(NOT_DIVISIBLE_BY_SMALLEST_COIN_ERROR_MESSAGE, Coin.getSmallestCoinAmount()));
		}
	}

	private static int toInteger(String inputAmount) {
		try {
			return Integer.parseInt(inputAmount);
		} catch (IllegalArgumentException exception) {
			throw new IllegalArgumentException(AMOUNT_IS_NOT_INTEGER_ERROR_MESSAGE);
		}
	}

	private static boolean isLessThanCertainCoinAmount(int certainCoinAmount, int inputAmount) {
		return certainCoinAmount > inputAmount;
	}

	private static boolean isDivisibleBySmallestCoinAmount(int amount) {
		return amount % Coin.getSmallestCoinAmount() != 0;
	}
}
