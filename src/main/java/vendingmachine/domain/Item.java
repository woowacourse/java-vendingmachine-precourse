package vendingmachine.domain;

public class Item implements Comparable<Item>{

	private String name;
	private int price;
	private int stockQuantity;

	public Item(String name, int price, int stockQuantity) {
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}

	public int getPrice() {
		return price;
	}

	public boolean isName(String name) {
		return this.name.equals(name);
	}

	public boolean isAvailableToBuy() {
		return this.stockQuantity > 0;
	}

	public boolean isAvailableToBuy(int money) {
		return this.price <= money;
	}

	public void subtractStockQuantity() {
		if (stockQuantity > 0) {
			stockQuantity--;
		}
	}

	public int subtractMoneyAfterPurchase(int money) {
		return money - price;
	}

	@Override
	public String toString() {
		return "Item{" +
			"name='" + name + '\'' +
			", price=" + price +
			", stockQuantity=" + stockQuantity +
			'}';
	}

	@Override
	public int compareTo(Item other) {
		return this.price - other.price;
	}
}
