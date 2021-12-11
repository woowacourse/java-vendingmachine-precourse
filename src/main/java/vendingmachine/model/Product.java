package vendingmachine.model;

public class Product {

	private String name;
	private int price;
	private int quantity;

	public Product(String[] productSplitByFormat) {
		this.name = productSplitByFormat[0];
		this.price = Integer.parseInt(productSplitByFormat[1]);
		this.quantity = Integer.parseInt(productSplitByFormat[2]);
	}

	public boolean isProduct(String name) {
		return this.name.equals(name);
	}
}
