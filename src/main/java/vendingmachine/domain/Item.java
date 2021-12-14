package vendingmachine.domain;

public class Item {
	private final String name;
	private final int price;
	private int stocks;

	public Item(String name, int price, int stocks) {
		this.name = name;
		this.price = price;
		this.stocks = stocks;
	}

	public static Item of(String name, int price, int stocks) {
		return new Item(name, price, stocks);
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getStocks() {
		return stocks;
	}

	public void sell() {
		stocks -= 1;
	}

	public boolean isNotSoldOut() {
		return stocks != 0;
	}

}
