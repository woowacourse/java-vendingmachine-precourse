package vendingmachine.domain.repository;

import vendingmachine.util.PublicConst;

public class MoneyRepository {
	private int amount = PublicConst.NOT_EXIST;

	public int getAmount() {
		return amount;
	}

	public void addAmount(int money) {
		this.amount += money;
	}

	public void deductAmount(int money) {
		this.amount -= money;
	}
}
