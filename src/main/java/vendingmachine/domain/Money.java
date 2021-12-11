package vendingmachine.domain;

public class Money {
	private int money;

	public Money(int money) {
		this.money = money;
	}

	public void pay(int moneyAmount) {
		reduce(moneyAmount);
	}

	public boolean checkPayable(int moneyAmount) {
		return money >= moneyAmount;
	}

	private void reduce(int moneyAmount) {
		money -= moneyAmount;
	}
}
