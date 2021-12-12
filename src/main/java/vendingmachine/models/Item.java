package vendingmachine.models;

public class Item {
	private final int price;
	private int amount;

	public Item(int price, int amount) {
		this.price = price;
		this.amount = amount;
	}

	public int getPrice() {
		return this.price;
	}
}

