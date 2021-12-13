package vendingmachine.model;

public class Product {
	private final String name;
	private final int price;
	private int quantity;

	public Product(String name, int price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public Product(String[] productDetail) {
		this.name = productDetail[0];
		this.price = Integer.parseInt(productDetail[1]);
		this.quantity = Integer.parseInt(productDetail[2]);
	}
}
