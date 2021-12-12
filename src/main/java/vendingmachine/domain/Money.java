package vendingmachine.domain;

import vendingmachine.utils.Validator;

public class Money {
	private int money;

	public Money(int money) {
		Validator.validateMoney(money);
		Validator.validateDivideMoneyBy10Coin(money);
		this.money = money;
	}

	public int getMoney() {
		return money;
	}

	public void deductMoney(Money minusMoney) {
		money -= minusMoney.getMoney();
	}
}
