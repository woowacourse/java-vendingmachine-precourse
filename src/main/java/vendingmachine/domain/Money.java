package vendingmachine.domain;

public class Money {
	private final int money;

	Money(int money) {
		this.money = money;
	}

	public Money reduce(int amount) {
		//예외처리 필요
		return new Money(this.money - amount);
	}
}
