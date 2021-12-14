package vendingmachine.model;

import static vendingmachine.ValidationUtils.*;

import java.util.Objects;

public class Item {
	private final String name;
	private final int price;
	private int count;

	public Item(String itemString) {
		String[] itemToAdd = validItemStatus(itemString);
		this.name = itemToAdd[0];
		this.price = Integer.parseInt(itemToAdd[1]);
		this.count = Integer.parseInt(itemToAdd[2]);
	}

	public static void validName(String name) {
		isBlank(name);
	}

	public static void validPrice(String priceStr) {
		int price = validNumberFormat(priceStr);
		validUnitMoney(price);
		isPositive(price);
	}

	public static void validCount(String countStr) {
		int count = validNumberFormat(countStr);
		isPositive(count);
	}

	public static String[] validItemStatus(String itemString) {
		String[] itemStatus = itemString.substring(1, itemString.length() - 1).split(",");
		validName(itemStatus[0]);
		validPrice(itemStatus[1]);
		validCount(itemStatus[2]);
		return itemStatus;
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

	public boolean sameName(Item itemName) {
		return this.equals(itemName);
	}

	public boolean hasStock(String itemName) {
		return name.equals(itemName) && count > 0;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Item item = (Item)o;
		return Objects.equals(name, item.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
