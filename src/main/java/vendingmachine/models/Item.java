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

	public int getAmount() {
		return this.amount;
	}

	public boolean isAmountZero() {
		return this.amount <= 0;
	}

	public void increaseAmount(int value) {
		this.amount += value;
	}

	public void decreaseAmount(int value) {
		this.amount -= value;
	}

	public boolean isOverThisPrice(int money) {
		return this.price > money;
	}
}

