package vendingmachine.domain;

import vendingmachine.utils.ErrorMessage;

public class Money {
	private int money;

	public Money(int money) {
		validateMoney(money);
		validateDivideMoneyBy10Coin(money);
		this.money = money;
	}

	public int getMoney() {
		return money;
	}

	public void deductMoney(int minusMoney) {
		money -= minusMoney;
	}

	public boolean isBigMyMoney(int anotherMoney) {
		if (money > anotherMoney) {
			return true;
		}
		return false;
	}

	public static void validateMoney(int money) {
		if (money <= 0) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_ERROR_MESSAGE);
		}
	}

	public static void validateDivideMoneyBy10Coin(int merchandisePrice) {
		if (merchandisePrice % 10 != 0) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_MERCHANDISE_PRICE_NOT_DIVIDE_10_COIN_ERROR_MESSAGE);
		}
	}
}
