package vendingmachine.utils;

import vendingmachine.domain.Coin;
import vendingmachine.exceptions.NotDivisibleByMinPriceCoinException;

public class ArithmeticValidator {
	public static void validateDividingByMinPriceCoin(String input, String errorMesssage) {
		if (Integer.parseInt(input) % Coin.getMinPriceCoin().getAmount() != 0) {
			throw new NotDivisibleByMinPriceCoinException(errorMesssage);
		}
	}

	public static void validateDividingByMinPriceCoin(int input, String errorMesssage) {
		if (input % Coin.getMinPriceCoin().getAmount() != 0) {
			throw new NotDivisibleByMinPriceCoinException(errorMesssage);
		}
	}
}
