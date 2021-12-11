package vendingmachine.payments;

import vendingmachine.money.Money;

public class Payments {
	private static final String PREFIX = "자판기에 투입하는 ";

	private Money moneyForBuying;

	public void insert(String money) {
		this.moneyForBuying = new Money(money, PREFIX);
	}

	public Money getRemainMoney() {
		return moneyForBuying;
	}

	public void pay(int productValue) {
		moneyForBuying.pay(productValue);
	}
}
