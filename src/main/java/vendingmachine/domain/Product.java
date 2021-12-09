package vendingmachine.domain;

public class Product {

	String name;
	int price;
	int amount;

	public Product(String name, int price, int amount) {
		this.name = name;
		this.price = price;
		this.amount = amount;
	}
}
