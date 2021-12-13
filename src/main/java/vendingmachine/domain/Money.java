package vendingmachine.domain;

import vendingmachine.utils.ValidateUtils;

public class Money {

	private final int money;

	public Money(String money) {
		validateMoney(money);
		this.money = Integer.parseInt(money);
	}

	private void validateMoney(String money) {
		ValidateUtils.validateInputCoin(money);
	}
}
