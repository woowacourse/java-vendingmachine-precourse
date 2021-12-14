package vendingmachine;

public class ProductEntry {
	private final int price;
	private int number;

	public ProductEntry(final int price, final int number) {
		this.price = price;
		this.number = number;
	}

	public int getPrice() {
		return this.price;
	}

	public void decrementNumber() {
		number--;
	}

	public boolean isAffordable(final int money) {
		return money >= price;
	}
}
