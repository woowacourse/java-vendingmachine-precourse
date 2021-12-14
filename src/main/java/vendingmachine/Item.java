package vendingmachine;

public class Item {
	private final String name;
	private final int price;
	private int amount;

	public Item(String name, int price, int amount) {
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	public boolean isAmountZero() {
		return this.amount == 0;
	}

	public boolean isBuyable(int insertAmount) {
		return this.price <= insertAmount;
	}

	public boolean isMathcing(String buyingItem) {
		return this.name.equals(buyingItem);
	}

	public int sell(int insertAmount) {
		this.amount--;
		return insertAmount - this.price;
	}
}
