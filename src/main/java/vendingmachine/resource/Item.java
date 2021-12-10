package vendingmachine.resource;

public class Item {
	String name;
	int price;
	int quantity;

	public Item(String name, int price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
}
