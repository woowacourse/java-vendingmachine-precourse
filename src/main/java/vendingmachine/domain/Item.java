package vendingmachine.domain;

public class Item {
	private String name;
	private int price;
	private int quantity;

	public Item(String name, int price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public int getPrice() {
		return this.price;
	}

	public boolean isSoldOut() {
		return this.quantity == 0;
	}

	public void decreaseQuantity() {
		this.quantity -= 1;
	}
}
