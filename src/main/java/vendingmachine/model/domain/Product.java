package vendingmachine.model.domain;

public class Product {
	private String name;
	private int price;
	private int amount;

	public Product() {
	}

	public Product(String name, int price, int amount) {
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	public String getName() {
		return this.name;
	}

	public int getPrice() {
		return this.price;
	}

	public int getAmount() {
		return this.amount;
	}

	public Product purchaseProduct() {
		this.amount--;
		return this;
	}

	public boolean getProductToDelete() {
		return this.amount == 0;
	}

	public boolean getEqualProduct(String productName) {
		return this.name.equals(productName);
	}
}
