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

	public int purchaseOne(int money) {
		stock -= 1;
		return money - price;
	}

	public boolean isStockRemain() {
		if (stock > 0) {
			return true;
		}
		return false;
	}

	public String getName() {
		return name;
	}
}
