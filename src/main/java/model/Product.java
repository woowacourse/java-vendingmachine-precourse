package model;

public class Product {
	private final String name;
	private final int price;
	private final int count;

	public Product(String name, int price, int count) {
		this.name = name;
		this.price = price;
		this.count = count;
	}

	public boolean isSoldOut() {
		if (count == 0) {
			return true;
		}
		return false;
	}

	public int bringPrice() {
		return price;
	}
}
