package vendingmachine;

public class Item {
	private final String name;
	private final int price;
	private int amount;

	public Item(String name, int price, int amount) {
		this.name = name;
		this.price = price;
		this.amount = amount;
	}
}
