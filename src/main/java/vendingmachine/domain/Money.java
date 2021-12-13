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

	public void deductMoney(int minusMoney) {
		money -= minusMoney;
	}

	public boolean isBigMyMoney(int anotherMoney) {
		if (money > anotherMoney) {
			return true;
		}
		return false;
	}
}
