package vendingmachine.domain;

public class Quantity {
	private int quantity;

	public Quantity(String value) {
		this.quantity = Integer.parseInt(value);
	}

	public int get() {
		return quantity;
	}

	public void add(int quantity) {
		this.quantity += quantity;
	}
}
