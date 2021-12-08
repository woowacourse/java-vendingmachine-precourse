package vendingmachine.domain;

public class Item {

	private String name;
	private int price;
	private int stockQuantity;

	public Item(String name, int price, int stockQuantity) {
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}

	@Override
	public String toString() {
		return "Item{" +
			"name='" + name + '\'' +
			", price=" + price +
			", stockQuantity=" + stockQuantity +
			'}';
	}
}
