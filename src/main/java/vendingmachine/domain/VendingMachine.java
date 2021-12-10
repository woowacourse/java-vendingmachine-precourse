package vendingmachine.domain;

import vendingmachine.exceptions.NotDivisibleByMinPriceCoinException;

public class VendingMachine {
	private static final String ERROR_NOT_INTEGER = "[ERROR] 보유 금액은 정수입니다";
	private static final String ERROR_LT_MIN_PRICE_COIN = "[ERROR] 보유 금액은 10원 이상입니다.";
	private static final String ERROR_NOT_DIVISIBLE_BY_MIN_PRICE_COIN = "[ERROR] 보유 금액은 10원의 배수입니다.";
	private Coins leftCoins;

	public VendingMachine(Coins leftCoins) {
		this.leftCoins = leftCoins;
	}

	public VendingMachine(String initalLeftMoney) {
		validateInitialLeftMoney(initalLeftMoney);
	}

	private void validateInitialLeftMoney(String initialLeftMoney) {
		validateInteger(initialLeftMoney);
		int leftMoney = Integer.parseInt(initialLeftMoney);

		validateGreaterThanOrEqualToMinPriceCoin(leftMoney);
		validateDividingByMinPriceCoin(leftMoney);
	}

	private void validateInteger(String initialLeftMoney) {
		if (!initialLeftMoney.matches("[0-9]+")) {
			throw new IllegalArgumentException(ERROR_NOT_INTEGER);
		}
	}

	private void validateGreaterThanOrEqualToMinPriceCoin(int leftMoney) {
		if (leftMoney < 10) {
			throw new IllegalArgumentException(ERROR_LT_MIN_PRICE_COIN);
		}
	}

	private void validateDividingByMinPriceCoin(int leftMoney) {
		if (leftMoney % 10 != 0) {
			throw new NotDivisibleByMinPriceCoinException(ERROR_NOT_DIVISIBLE_BY_MIN_PRICE_COIN);
		}
	}
}

