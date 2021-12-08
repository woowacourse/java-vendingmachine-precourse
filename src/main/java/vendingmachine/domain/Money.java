package vendingmachine.domain;

import vendingmachine.utils.Validator;

public class Money {
	private int money;

	public Money(int money) {
		Validator.validateMoney(money);
		this.money = money;
	}
}
