package vendingmachine.domain;

public class Money {
	private int total;

	public Money() {
		this.total = 0;
	}

	public Money(int amount) {
		this.total = amount;
	}

	public int getTotal() {
		return total;
	}

	public boolean isSame(int money) {
		return total == money;
	}

	public boolean isSmaller(int money) {
		return total < money;
	}

	public void spend(int money) {
		total -= money;
	}
}
