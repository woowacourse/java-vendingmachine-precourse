package vendingmachine.resource;

public class Item {
	private final String name;
	private final int price;
	private int stock;

	public Item(String name, int price, int stock) {
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getStock() {
		return stock;
	}

	public void reduceStock() {
		stock -= 1;
	}
}
