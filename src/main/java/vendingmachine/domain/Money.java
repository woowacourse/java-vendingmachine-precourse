package vendingmachine.domain;

import vendingmachine.utils.ValidateUtils;

public class Money {

	private int money;

	public Money(String money) {
		validateMoney(money);
		this.money = Integer.parseInt(money);
	}

	private void validateMoney(String money) {
		ValidateUtils.validateInputCoin(money);
	}

	public boolean hasMoreMoney() {
		return money > 0;
	}

	public boolean isPossibleChangeToCoin(int amount) {
		return money >= amount;
	}

	public void changeToCoin(int amount) {
		spendMoney(amount);
	}

	public void spendMoney(int amount) {
		money -= amount;
	}

	public boolean isEnoughMoney(int minimumProductPrice) {
		return money >= minimumProductPrice;
	}

	public int getUserMoney() {
		return money;
	}
}
