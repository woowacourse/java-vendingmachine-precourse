package vendingmachine.domain;

import vendingmachine.util.PublicConst;

public class Item {
	private String name;
	private int price;
	private int amount;

	public Item(String name, int price, int amount) {
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public boolean canPurchase(int money) {
		return price <= money && isInStock();
	}

	public boolean isInStock() {
		return this.amount > PublicConst.NOT_EXIST;
	}

	public void deductAmount() {
		this.amount--;
	}

	@Override
	public String toString() {
		return PublicConst.ITEM_WRAP_LEFT
			+ String.join(PublicConst.ITEM_PARAMETER_SEPARATOR,
			name,
			price + PublicConst.MONETARY_UNIT,
			amount + PublicConst.COUNT_LITERAL)
			+ PublicConst.ITEM_WRAP_RIGHT;
	}
}
