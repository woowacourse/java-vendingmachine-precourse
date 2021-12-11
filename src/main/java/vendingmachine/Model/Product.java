package vendingmachine.Model;

public class Product {
	public final String NAME;
	public final int PRICE;
	private int stock;

	public Product(Object[] values) {
		NAME = (String)values[0];
		PRICE = (int)values[1];
		this.stock = (int)values[2];
	}

	public void sell() {
		stock--;
	}

	public boolean isSoldOut() {
		return stock == 0;
	}
}
