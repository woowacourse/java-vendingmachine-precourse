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
