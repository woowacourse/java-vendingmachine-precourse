package vendingmachine.domain;

import static vendingmachine.NumberConstant.*;

public class Item implements Comparable<Item>{

	private String name;
	private int price;
	private int stockQuantity;

	public Item(String name, int price, int stockQuantity) {
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}

	public boolean isName(String name) {
		return this.name.equals(name);
	}

	public boolean isName(Item item) {
		return this.name.equals(item.name);
	}

	public boolean isAvailableToBuy() {
		return this.stockQuantity > ZERO;
	}

	public boolean isAvailableToBuy(int money) {
		return this.price <= money;
	}

	public void subtractStockQuantity() {
		if (stockQuantity > ZERO) {
			stockQuantity--;
		}
	}

	public int subtractMoneyAfterPurchase(int money) {
		return money - price;
	}

	@Override
	public int compareTo(Item other) {
		return this.price - other.price;
	}
}
