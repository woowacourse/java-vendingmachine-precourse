package vendingmachine.validator;

import static vendingmachine.constant.ErrorMessage.*;

import vendingmachine.domain.coin.Coin;

public class AmountValidator {
	public static void checkUserAmount(int userAmount) {
		checkVendingMachineAmount(userAmount);
	}

	public static void checkVendingMachineAmount(int vendingMachineAmount) {
		checkAmountBiggerThanCertainCoinAmount(Coin.getSmallestCoinAmount(), vendingMachineAmount);
		checkAmountDivisibleBySmallestCoinAmount(vendingMachineAmount);
	}

	public static void checkProductAmount(int productAmount) {
		checkAmountBiggerThanCertainCoinAmount(Coin.getSecondBiggestCoinAmount(), productAmount);
		checkAmountDivisibleBySmallestCoinAmount(productAmount);
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
