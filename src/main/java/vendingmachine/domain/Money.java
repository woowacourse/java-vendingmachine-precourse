package vendingmachine.domain;

import vendingmachine.Coin;

public class Money {
	private static final String IS_DIVIDE_BY_TEN_ERROR_MESSAGE = "돈은 10의 배수여야 한다.";

	private int amount;

	public Money(int amount) throws IllegalArgumentException {
		validateIsDivideByTen(amount);
		this.amount = amount;
	}

	private void validateIsDivideByTen(int amount) throws IllegalArgumentException {
		if (amount % Coin.COIN_10.getAmount() != 0) {
			throw new IllegalArgumentException(IS_DIVIDE_BY_TEN_ERROR_MESSAGE);
		}
	}

	public int getAmount() {
		return amount;
	}
}
