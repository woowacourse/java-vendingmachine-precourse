package vendingmachine.domain;

public class Merchandise {
	private String name;
	private Money money;
	private int quantity;

	public Merchandise(String name, Money money, int quantity) {
		this.name = name;
		this.money = money;
		this.quantity = quantity;
	}
}
