package vendingmachine.Model;

public class Product {
	private final String NAME;
	private final int PRICE;
	private final int STOCK;

	public Product(String name, int price, int stock) {
		NAME = name;
		PRICE = price;
		STOCK = stock;
	}
}
