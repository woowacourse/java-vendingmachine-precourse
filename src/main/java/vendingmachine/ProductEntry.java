package vendingmachine;

public class ProductEntry {
	private final int price;
	private int number;

	public ProductEntry(int price, int number) {
		this.price = price;
		this.number = number;
	}

	public int getPrice() {
		return this.price;
	}

	public void decrementNumber() {
		number--;
	}

	public boolean isAffordable(int money) {
		return money >= price;
	}

}
