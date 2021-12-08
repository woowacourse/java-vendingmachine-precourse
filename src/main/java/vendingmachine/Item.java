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
}
