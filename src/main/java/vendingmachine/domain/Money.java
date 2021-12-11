package vendingmachine.domain;

public class Money {
	private static final int ZERO = 0;

	private final int money;

	public Money(int money) {
		this.money = money;
	}

	public Money reduce(int amount) {
		//예외처리 필요
		return new Money(this.money - amount);
	}

	public boolean isRemain() {
		return money > ZERO;
	}

	public int getMoney() {
		return money;
	}
}
