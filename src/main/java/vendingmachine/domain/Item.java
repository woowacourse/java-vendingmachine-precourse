package vendingmachine.domain;

import java.util.Objects;

public class Item {
	private String name;
	private int price;
	private int count;

	public Item(String name, int price, int count) {
		this.name = name;
		this.price = price;
		this.count = count;
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
