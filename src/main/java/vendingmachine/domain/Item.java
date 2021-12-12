package vendingmachine.domain;

public class Item {
	private String name;
	private int price;
	private int amount;

	public Item(String name, int price, int amount) {
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getAmount() {
		return amount;
	}

	public boolean isInStock() {
		return this.amount > 0;
	}

	public void deductAmount() {
		this.amount--;
	}
}
