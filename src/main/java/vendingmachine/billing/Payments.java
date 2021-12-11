package vendingmachine.billing;

public class Payments {
	private Money moneyForBuying;

	public void insert(Money moneyForBuying) {
		this.moneyForBuying = moneyForBuying;
	}

	public Money getRemainMoney() {
		return moneyForBuying;
	}

	public void payFor(int productValue) {
		moneyForBuying.pay(productValue);
	}
}
