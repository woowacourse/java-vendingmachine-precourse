package vendingmachine.domain;

public class Quantity {
	private final int quantity;

	public Quantity(int quantity) {
		this.quantity = quantity;
	}

	public static Quantity from(String quantity) {
		return new Quantity(Integer.parseInt(quantity));
	}
}
