package vendingmachine.domain;

public class Item {
	private String itemName;
	private int price;
	private int quantity;

	public Item(String itemName, int price, int quantity) {
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}

	public int getPrice() {
		return this.price;
	}

	public void reduceQuantity() {
		this.quantity--;
	}

	public boolean isZeroQuantity() {
		return this.quantity == 0;
	}

	public boolean isEqualItemName(String itemName) {
		return this.itemName.equals(itemName);
	}
}
