package vendingmachine.domain;

import java.util.Objects;

public class Item {

	public static final int ITEM_NAME_INDEX = 0;
	public static final int ITEM_PRICE_INDEX = 1;
	public static final int ITEM_COUNT_INDEX = 2;

	private String name;
	private int price;
	private int count;

	public Item(String name, int price, int count) {
		this.name = name;
		this.price = price;
		this.count = count;
	}

	public int getPrice() {
		return price;
	}

	public void minusCount() {
		if (!canBuy(count)) {
			throw new IllegalArgumentException("[ERROR] 재고량이 부족합니다.");
		}
		this.count--;
	}

	private boolean canBuy(int count) {
		return this.count >= 0;
	}

	public boolean equalName(String inputName) {
		return name.equals(inputName);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Item))
			return false;
		Item item = (Item)o;
		return price == item.price && count == item.count && Objects.equals(name, item.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, price, count);
	}

	@Override
	public String toString() {
		return "Item{" +
			"name='" + name + '\'' +
			", price=" + price +
			", count=" + count +
			'}';
	}
}
