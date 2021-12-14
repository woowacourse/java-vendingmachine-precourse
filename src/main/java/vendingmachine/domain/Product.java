package vendingmachine.domain;

public class Product {
	private String name;
	private int price;
	private int quantity;
	private static final int OUT_OF_STOCK = 0;

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

	public int getQuantity() {
		return quantity;
	}

	public void reduceQuantity() {
		quantity--;
	}

	public boolean checkStock() {
		return quantity > OUT_OF_STOCK;
	}

	public boolean checkPriceWithCurrentMoney(int currentMoney) {
		return price <= currentMoney;
	}

}
