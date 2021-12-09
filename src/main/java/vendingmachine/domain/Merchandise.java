package vendingmachine.domain;

import java.util.Objects;

public class Merchandise {
	private String name;
	private Money money;
	private int quantity;

	public Merchandise(String name, Money money, int quantity) {
		this.name = name;
		this.money = money;
		this.quantity = quantity;
	}

	public Money getMoney() {
		return money;
	}

	public String getName() {
		return name;
	}
}
