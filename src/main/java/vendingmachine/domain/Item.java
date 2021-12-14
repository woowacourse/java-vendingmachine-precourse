package vendingmachine.domain;

public class Item {

	private static final int OUT_OF_STOCK = 0;

	private final String name;
	private final int price;
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

	public boolean checkPurchase(int amount) {
		return price <= amount;
	}

	public int purchase(int amount) {
		quantity--;
		return amount - price;
	}

	public boolean checkOutOfStock() {
		return quantity == OUT_OF_STOCK;
	}

	public boolean checkEqualsName(String itemName) {
		return name.equals(itemName);
	}
}
