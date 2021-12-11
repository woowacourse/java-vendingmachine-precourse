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

	public String getItemName() {
		return itemName;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void sellItem() {
		this.quantity--;
	}

	@Override
	public String toString() {
		return "Item{" +
			"itemName='" + itemName + '\'' +
			", price=" + price +
			", quantity=" + quantity +
			'}';
	}
}
