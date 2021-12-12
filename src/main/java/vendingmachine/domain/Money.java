package vendingmachine.domain;

public class Money {
	private int money;

	public Money(String value) {
		this.money = Integer.parseInt(value);
	}

	public int get() {
		return money;
	}
}
