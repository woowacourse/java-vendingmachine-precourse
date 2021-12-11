package vendingmachine.domain;

public class Product {

	private String name;
	private int price;
	private int quantity;

	public Product(String name, int price) {
		this.name = name;
		this.price = price;
		this.quantity = 0;
	}

	public Product(String name, int price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int decreaseQuantity() {
		return --quantity;
	}
}
