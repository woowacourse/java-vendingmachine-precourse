package vendingmachine.domain;

public class Item {
	private static final int EMPTY = 0;

	private final String name;
	private final int price;
	private int quantity;

	public Item(String name, String price, String quantity) {
		this.name = name;
		this.price = Integer.parseInt(price);
		this.quantity = Integer.parseInt(quantity);
	}

	public boolean exists() {
		return quantity != EMPTY;
	}

	public void reduceQuantity() {
		quantity--;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
}
