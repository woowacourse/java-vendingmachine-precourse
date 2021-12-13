package vendingmachine.domain;

public class Item {
	private String name;
	private int price;
	private int num;

	public Item(String name, int price, int num) {
		this.name = name;
		this.price = price;
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Item{" +
			"name='" + name + '\'' +
			", price=" + price +
			", num=" + num +
			'}';
	}
}
