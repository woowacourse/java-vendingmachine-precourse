package vendingmachine.domain;

import vendingmachine.exceptions.NotDivisibleByMinPriceCoinException;

public class VendingMachine {
	private static final String ERROR_NOT_INTEGER = "[ERROR] 보유 금액은 정수입니다.";
	private static final String ERROR_LT_MIN_PRICE_COIN = "[ERROR] 보유 금액은 10원 이상입니다.";
	private static final String ERROR_NOT_DIVISIBLE_BY_MIN_PRICE_COIN = "[ERROR] 보유 금액은 10원의 배수입니다.";
	private Coins leftCoins;

	public VendingMachine(Coins leftCoins) {
		this.leftCoins = leftCoins;
	}

	public static VendingMachine of(String initalLeftMoney) {
		validateInitialLeftMoney(initalLeftMoney);
		Coins coins = null;
		return new VendingMachine(coins);
	}

	private static void validateInitialLeftMoney(String initialLeftMoney) {
		validateInteger(initialLeftMoney);
		int leftMoney = Integer.parseInt(initialLeftMoney);

		validateGreaterThanOrEqualToMinPriceCoin(leftMoney);
		validateDividingByMinPriceCoin(leftMoney);
	}

	private static void validateInteger(String initialLeftMoney) {
		if (!initialLeftMoney.matches("[0-9]+")) {
			throw new IllegalArgumentException(ERROR_NOT_INTEGER);
		}
	}

	private static void validateGreaterThanOrEqualToMinPriceCoin(int leftMoney) {
		if (leftMoney < Coin.getMinPriceCoin().getAmount()) {
			throw new IllegalArgumentException(ERROR_LT_MIN_PRICE_COIN);
		}
	}

	private static void validateDividingByMinPriceCoin(int leftMoney) {
		if (leftMoney % Coin.getMinPriceCoin().getAmount() != 0) {
			throw new NotDivisibleByMinPriceCoinException(ERROR_NOT_DIVISIBLE_BY_MIN_PRICE_COIN);
		}
	}
}

