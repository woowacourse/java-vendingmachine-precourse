package vendingmachine.domain;

public class Beverage {
	private String name;
	private int price;
	private int stock;

	public Beverage(String name, int price, int stock) {
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
}
