package vendingmachine.domain.repository;

public class MoneyRepository {
	private int amount = 0;

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
