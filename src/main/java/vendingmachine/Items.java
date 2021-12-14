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

	public boolean sellItem() {
		if (stock == 0) {
			return false;
		}
		stock--;
		return true;
	}

	public int getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}
}
