package vendingmachine.domain;

public class Money {
	private int money;

	public Money(final int money) {
		this.money = money;
	}

	public void reduce(final int moneyAmount) {
		money -= moneyAmount;
	}

	public int getMoney() {
		return money;
	}
}
