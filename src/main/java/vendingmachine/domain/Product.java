package vendingmachine.domain;

public class Product {
	private final String name;
	private final int price;
	private final int count;

	public Product(String name, int price, int count) {
		this.name = name;
		this.price = price;
		this.count = count;
	}

	public Product(String[] productSplit) {
		this(productSplit[0], Integer.parseInt(productSplit[1]), Integer.parseInt(productSplit[2]));
	}
}
