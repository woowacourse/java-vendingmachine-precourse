package vendingmachine.models;

import java.util.HashMap;

public class ItemList {
	private HashMap<String, Item> ItemList;

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
}
