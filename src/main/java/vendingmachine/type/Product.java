package vendingmachine.type;

public class Product {
	private String name;
	private int price;
	private int quantity;

	public Product(String name, int price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public boolean isSoldOut() {
		return quantity <= 0;
	}

	public boolean isPossibleToBuy(int balance) {
		return price <= balance;
	}

	public void sell() {
		quantity--;
	}
}
