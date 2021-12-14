package vendingmachine;

public class Items {
	private String name;
	private int price;
	private int stock;

	Items(String name, String price, String stock) {
		this.name = name;
		this.price = Integer.parseInt(price);
		this.stock = Integer.parseInt(stock);
	}

	public int sellItem() {
		if (stock < 0) {
			return -1;
		}
		stock--;
		return stock;
	}

	public int getStock() {
		return stock;
	}

	public int getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}
}
