package vendingmachine.models;

import java.util.HashMap;

import vendingmachine.utils.Validator;

public class ItemList {
	private HashMap<String, Item> itemList;
	private static final int DECREMENTAL_VALUE = 1;

	public ItemList(HashMap<String, Item> parsedInput) {
		this.itemList = new HashMap<>();
		for (String eachName : parsedInput.keySet()) {
			int price = parsedInput.get(eachName).getPrice();
			int amount = parsedInput.get(eachName).getAmount();
			Item nowItem = new Item(price, amount);
			this.itemList.put(eachName, nowItem);
		}
	}

	public int getItemPrice(String name) {
		return this.itemList.get(name).getPrice();
	}

	public int getMinPrice() {
		return this.itemList.values()
			.stream()
			.filter(eachItem -> !eachItem.isAmountZero())
			.mapToInt(Item::getPrice)
			.min()
			.getAsInt();
	}

	public boolean isAllSoldOut() {
		int totalItemCount = this.itemList.size();
		int soldOutItemCount = (int)this.itemList.values().stream().filter(Item::isAmountZero).count();
		if (soldOutItemCount == totalItemCount) {
			return true;
		}
		return false;
	}

	public void sellItem(String name, int payMoney) {
		Validator.validateBuyingConditions(this.itemList, name, payMoney);
		this.itemList.get(name).decreaseAmount(DECREMENTAL_VALUE);
	}
}
