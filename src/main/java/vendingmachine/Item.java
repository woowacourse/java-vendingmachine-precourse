package vendingmachine;

import static vendingmachine.ValidationUtils.*;

public class Item {
	private String name;
	private int price;
	private int count;

	public Item(String name, int price, int count) {
		this.name = name;
		this.price = price;
		this.count = count;
	}

	public Item(String itemString) {
		String[] itemToAdd = itemString.substring(1, itemString.length() - 1).split(",");
		this.name = itemToAdd[0];
		this.price = Integer.parseInt(itemToAdd[1]);
		this.count = Integer.parseInt(itemToAdd[2]);
	}

	public static boolean validName(String name) {
		return !isBlank(name);
	}

	public static boolean validPrice(int price) {
		return validUnitMoney(price) && isPositive(price);
	}

	public static boolean validCount(int count) {
		return isPositive(count);
	}

	public static boolean validItemStatus(String name, int price, int count) {
		return validName(name) && validPrice(price) && validCount(count);
	}

	public void sellItem() {
		count--;
	}

	public int getPrice() {
		return this.price;
	}

	public int getCount() {
		return this.count;
	}

	public String getName() {
		return this.name;
	}

	public String getStatus() {
		return this.name + this.getPrice() + this.getCount();
	}

	public boolean isOutOfStock() {
		return this.count == 0;
	}
}
