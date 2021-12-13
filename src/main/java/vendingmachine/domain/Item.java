package vendingmachine.domain;

public class Item implements Comparable<Item> {
	private String name;
	private int price;
	private int count;

	public Item(String name, int price, int count) {
		this.name = name;
		this.price = price;
		this.count = count;
	}

	public boolean isSameItem(String name) {
		return this.name.equals(name);
	}

	public boolean checkAbleToSell(int balance) {
		if (balance < price || count <= 0) {
			return false;
		}
		return true;
	}

	public int sell(int balance) {
		count -= 1;
		return balance - price;
	}

	public boolean isSoldOut() {
		return count == 0;
	}

	@Override
	public int compareTo(Item o) {
		return this.price - o.price;
	}
}
