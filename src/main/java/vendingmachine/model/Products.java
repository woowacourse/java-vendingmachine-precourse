package vendingmachine.model;

public class Products {
	private final String name;
	private final int price;
	private int count;

	public Products(String name, int price, int count) {
		this.name = name;
		this.price = price;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getCount() {
		return count;
	}
}
