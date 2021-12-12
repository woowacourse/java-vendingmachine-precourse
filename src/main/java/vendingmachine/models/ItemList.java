package vendingmachine.models;

import java.util.HashMap;

import vendingmachine.utils.Validator;

public class ItemList {
	private HashMap<String, Item> ItemList;
	private static final int DECREMENTAL_VALUE = 1;

	public ItemList(HashMap<String, Item> parsedInput) {
		this.ItemList = new HashMap<>();
		for (String eachName : parsedInput.keySet()) {
			int price = parsedInput.get(eachName).getPrice();
			int amount = parsedInput.get(eachName).getAmount();
			Item nowItem = new Item(price, amount);
			this.ItemList.put(eachName, nowItem);
		}
	}

	public int getItemPrice(String name) {
		return this.ItemList.get(name).getPrice();
	}

	public int getMinPrice() {
		return this.ItemList.values().stream().filter(eachItem -> !eachItem.isAmountZero()).mapToInt(Item::getPrice).min().getAsInt();
	}

	public boolean isAllSoldOut() {
		int totalItemCount = this.ItemList.size();
		int soldOutItemCount = (int)this.ItemList.values().stream().filter(Item::isAmountZero).count();
		if (soldOutItemCount == totalItemCount) {
			return true;
		}
		return false;
	}

	public void sellItem(String name) {
		this.ItemList.get(name).decreaseAmount(DECREMENTAL_VALUE);
	}

	private void checkItemName(String itemName) {
		Validator.isItemName(this.ItemList, itemName);
	}

	private void checkPayMoney(String itemName, int payMoney) {
		Validator.validatePayAmount(this.ItemList, itemName, payMoney);
	}
}
