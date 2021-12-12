package vendingmachine.validator;

import static vendingmachine.constant.ErrorMessage.*;

import vendingmachine.domain.coin.Coin;

public class AmountValidator {

	public static void checkVendingMachineAmount(String vendingMachineAmount) {
		int amount = toInteger(vendingMachineAmount);
		checkAmountDivisibleBySmallestCoinAmount(amount);
		checkAmountBiggerThanCertainCoinAmount(Coin.getSmallestCoinAmount(), Integer.parseInt(vendingMachineAmount));
	}

	public static void checkProductAmount(int productAmount) {
		checkAmountDivisibleBySmallestCoinAmount(productAmount);
		checkAmountBiggerThanCertainCoinAmount(Coin.getSecondBiggestCoinAmount(), productAmount);
	}

	public static int toInteger(String amount) {
		try {
			return Integer.parseInt(amount);
		} catch (IllegalArgumentException exception) {
			throw new IllegalArgumentException(INPUT_IS_NOT_INTEGER_ERROR_MESSAGE);
		}
	}

	private static void checkAmountBiggerThanCertainCoinAmount(int certainCoinAmount, int amount) {
		if (certainCoinAmount > amount) {
			throw new IllegalArgumentException(String.format(LESS_THAN_CERTAIN_COIN_ERROR, certainCoinAmount));
		}
	}

	private static void checkAmountDivisibleBySmallestCoinAmount(int amount) {
		if (amount % Coin.getSmallestCoinAmount() != 0) {
			throw new IllegalArgumentException(
				String.format(NOT_DIVISIBLE_BY_SMALLEST_COIN_ERROR_MESSAGE, Coin.getSmallestCoinAmount()));
		}
	}
}
