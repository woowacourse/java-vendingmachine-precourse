package vendingmachine.domain;

public class Item {
	private final String name;
	private final int price;
	private int quantity;

	public Item(String name, String price, String quantity) {
		this.name = name;
		this.price = Integer.parseInt(price);
		this.quantity = Integer.parseInt(quantity);
	}
}
