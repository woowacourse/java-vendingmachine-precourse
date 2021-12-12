package vendingmachine.model;

public class Product {

	private final String name;
	private final int price;
	private int quantity;

	public Product(String[] productSplitByFormat) {
		this.name = productSplitByFormat[0];
		this.price = Integer.parseInt(productSplitByFormat[1]);
		this.quantity = Integer.parseInt(productSplitByFormat[2]);
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getName() {
		return name;
	}

	public boolean isOverZeroQuantity() {
		return quantity > 0;
	}

	public boolean isPurchase(int money) {
		return money >= price;
	}

	public void purchase() {
		quantity--;
	}
}
