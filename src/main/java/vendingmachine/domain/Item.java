package vendingmachine.domain;

import java.util.List;

public class Item {
	private String name;
	private int price;
	private int quantity;

	public Item(String name, int price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public boolean isEqualItemByName(String itemName){
		return name.equals(itemName);
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public boolean isEnoughQuantity() {
		return this.quantity > 0;
	}

	public boolean isEnoughMoneyForPurchasing(int remainingMoney) {
		return this.price <= remainingMoney;
	}

	public void reduceQuantity() {
		this.quantity -= 1;
	}

}
