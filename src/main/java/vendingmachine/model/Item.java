package vendingmachine.model;

import static vendingmachine.ValidationUtils.*;

public class Item {
	private String name;
	private int price;
	private int count;

	public Item(String itemString) {
		String[] itemToAdd = itemString.substring(1, itemString.length() - 1).split(",");
		this.name = itemToAdd[0];
		this.price = Integer.parseInt(itemToAdd[1]);
		this.count = Integer.parseInt(itemToAdd[2]);
	}

	public static void validName(String name) {
		isBlank(name);
	}

	public static void validPrice(int price) {
		validUnitMoney(price);
		isPositive(price);
	}

	public static void validCount(int count) {
		isPositive(count);
	}

	public static void validItemStatus(String name, int price, int count) {
		validName(name);
		validPrice(price);
		validCount(count);
	}

	public void sellItem(UserMoney userMoney) {
		userMoney.subtract(price);
		count--;
	}

	public boolean isOutOfStock() {
		return count == 0;
	}

	public int isMinPrice(int minPrice) {
		return Math.min(price, minPrice);
	}

	public boolean sameName(String itemName) {
		return name.equals(itemName);
	}
}
