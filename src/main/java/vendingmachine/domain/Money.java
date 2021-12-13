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

	public boolean compareMoney(Money anotherMoney) {
		if (money > anotherMoney.getMoney()) {
			return true;
		}
		return false;
	}
}
