package vendingmachine.domain;

import static vendingmachine.Constant.*;

public class Item {
	public String name;
	public int price;
	public int count;

	public Item(String[] itemInform) {
		this.name = itemInform[ITEM_NAME_INDEX];
		this.price = Integer.parseInt(itemInform[ITEM_PRICE_INDEX]);
		this.count = Integer.parseInt(itemInform[ITEM_COUNT_INDEX]);
	}

	public Item(String name, int price, int count) {
		this.name = name;
		this.price = price;
		this.count = count;
	}

	public void minusCount() {
		count -= 1;
	}
}
