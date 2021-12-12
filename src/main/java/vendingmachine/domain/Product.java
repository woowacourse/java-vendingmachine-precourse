package vendingmachine.domain;

public class Product implements Comparable<Product> {
	private String name;
	private int price;
	private int count;

	public Product(String name, int price, int count) {
		this.name = name;
		this.price = price;
		this.count = count;
	}

	public int getPrice() {
		return price;
	}

	public int sell() {
		return --count;
	}

	public boolean isEqual(String name) {
		return this.name.equals(name);
	}

	public boolean priceIsSmallerThan(int price) {
		return this.price <= price;
	}

	@Override
	public int compareTo(Product o) {
		if (this.price <= o.price) {
			return 1;
		}
		return 0;
	}
}
