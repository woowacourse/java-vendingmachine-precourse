package vendingmachine.domain;

public class Item {
	private String name = "";
	private int price = 0;
	private int stock = 0;

	public Item(String name, int price, int stock){
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	public String getName() {
		return this.name;
	}

	public int getPrice() {
		return this.price;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock){
		this.stock = stock;
	}
}
