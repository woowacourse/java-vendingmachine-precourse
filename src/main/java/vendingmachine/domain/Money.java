package vendingmachine.domain;

import vendingmachine.utils.Validator;

public class Money {
	private int money;

	public Money(int money) {
		Validator.validateMoney(money);
		this.money = money;
	}

	public int getMoney() {
		return money;
	}

	public int decideCoinCount(int money, Coin coinValue) {
		int coinCount = 0;
		if (coinValue.getAmount() <= money) {
			coinCount = money / coinValue.getAmount();
		}
		return coinCount;
	}
}
