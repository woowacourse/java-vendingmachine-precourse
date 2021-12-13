package vendingmachine.domain;

public class Money {
	private static final int ZERO = 0;

	private final int money;

	public Money(int money) {
		this.money = money;
	}

	public Money reduce(int amount) {
		return new Money(this.money - amount);
	}

	public boolean isRemain() {
		return money > ZERO;
	}

	public int getMoney() {
		return money;
	}

	public boolean isEqualsZero() {
		return this.money == 0;
	}
}
