package vendingmachine.domain;

public class Item {

	private static final int OUT_OF_STOCK = 0;

	private String name;
	private int price;
	private int quantity;

	public Item(String name, int price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int purchase() {
		quantity--;
		return price;
	}

	public boolean checkOutOfStock() {
		return quantity == OUT_OF_STOCK;
	}

	public boolean checkEqualsName(String itemName) {
		return name.equals(itemName);
	}
}
