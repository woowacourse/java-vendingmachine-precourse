package model;

public class Product {
	private final String name;
	private final int price;
	private int count;

	public Product(String name, int price, int count) {
		this.name = name;
		this.price = price;
		this.count = count;
	}

	public int getPrice() {
		return price;
	}

	public void reduceCount() {
		count -= 1;
	}

	public boolean isSoldOut() {
		return count == 0;
	}

	public boolean isSameName(String productName) {
		return name.equals(productName);
	}
}
