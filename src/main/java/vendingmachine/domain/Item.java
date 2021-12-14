package vendingmachine.domain;

import vendingmachine.constant.ErrorConst;

public class Item {
	private String name;
	private int price;
	private int num;

	public Item(String name, int price, int num) {
		this.name = name;
		this.price = price;
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public boolean isRemain() {
		return num > 0;
	}

	public int getPrice() {
		return price;
	}

	public boolean isAffordablePrice(int amount) {
		return price <= amount;
	}

	@Override
	public String toString() {
		return "Item{" +
			"name='" + name + '\'' +
			", price=" + price +
			", num=" + num +
			'}';
	}

	public void sell() {
		if (isRemain()) {
			num -= 1;
		}
	}
}
