package vendingmachine.resource;

public class Item {
	private final String name;
	private final int price;
	private int quantity;

	public Item(String name, int price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public int getPrice(){
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getName(){
		return name;
	}
}
