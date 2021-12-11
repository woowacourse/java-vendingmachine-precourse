package vendingmachine.domain;

public class Money {
	private int money;

	public Money(int money) {
		this.money = money;
	}

	public void pay(int moneyAmount) {
		reduce(moneyAmount);
	}

	public int getRemainingMoney() {
		return money;
	}

	private void reduce(int moneyAmount) {
		money -= moneyAmount;
	}
}
