package vendingmachine.domain;

import static vendingmachine.enums.ErrorMessage.*;

import vendingmachine.enums.Coin;

public class Money {
	private static final int INIT_MONEY = 0;

	private int money;

	public Money(String value) {
		validateNumberFormat(value);
		int money = Integer.parseInt(value);
		validateRange(money);
		validateDivisibleBy10(money);
		this.money = money;
	}

	public int get() {
		return money;
	}

	public void add(Money money) {
		this.money += money.money;
	}

	public void sub(Money price) {
		this.money -= price.money;
	}

	public boolean isLowerThen(Money money) {
		return this.money < money.money;
	}

	private void validateNumberFormat(String value) {
		try {
			Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(MONEY_NOT_NUMBER_ERROR_MESSAGE.get());
		}
	}

	private void validateRange(int money) {
		if (money < 0) {
			throw new IllegalArgumentException(MONEY_LOWER_THEN_ZERO_ERROR_MESSAGE.get());
		}
	}

	private void validateDivisibleBy10(int money) {
		if (money % Coin.COIN_10.get() != 0) {
			throw new IllegalArgumentException(MONEY_NOT_DIVISIBLE_BY_10_ERROR_MESSAGE.get());
		}
	}

	public void clear() {
		money = INIT_MONEY;
	}
}
