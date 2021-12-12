package vendingmachine.domain;

public class Product {
	private Name name;
	private Money price;
	private Quantity quantity;

	public Product(Name name, Money price, Quantity quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
}
