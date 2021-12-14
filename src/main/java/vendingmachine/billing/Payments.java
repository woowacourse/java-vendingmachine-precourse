package vendingmachine.billing;

public class Payments {
	private Money money;

	public void insert(Money money) {
		this.money = money;
	}

	public Money getRemainMoney() {
		return money;
	}

	public void payFor(int productValue) {
		money.pay(productValue);
	}
}
