package vendingmachine;

public class ProductEntry {
	private final int price;
	private int number;

	public ProductEntry(int price, int number) {
		this.price = price;
		this.number = number;
	}

	public void decrementNumber() {
		number--;
	}
}
