package vendingmachine.model;

public class Product {
	public static final int MINIMUM_PRICE = 100;
	public static final int MINIMUM_PRICE_UNIT = 10;

	private String name;
	private int price;
	private int stock;

	public Product(String name, int price, int stock) {
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
}
