package vendingmachine.repository;

import java.util.HashMap;
import java.util.List;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Item;
import vendingmachine.util.Symbol;

public class VendingMachine {
	private final HashMap<Coin, Integer> coins;
	private final HashMap<String, Item> items;

	public VendingMachine(List<Integer> coin) {
		this.coins = new HashMap<>();
		initCoins(coin);
		this.items = new HashMap<>();
	}

	private void initCoins(List<Integer> coin) {
		coin.stream().map(Coin::fromMoney).forEach(c -> coins.put(c, 0));
	}

	public void addCoin(Coin coin) {
		coins.put(coin, coins.getOrDefault(coin, 0) + 1);
	}

	public String currentSmallChange() {
		StringBuilder builder = new StringBuilder();
		coins.keySet().stream()
			.sorted((c1, c2) -> -1 * Integer.compare(c1.getAmount(), c2.getAmount()))
			.forEach(
				c -> builder.append(
					c.getAmount() + Symbol.WON + Symbol.HYPHEN_SPACE + coins.get(c) + Symbol.COUNT + Symbol.MEW_LINE));
		return builder.toString();
	}

	public void addItem(String itemName, Item item) {
		items.put(itemName, item);
	}

	public int getMinItemPrice() {
		return items.values().stream().mapToInt(i -> i.getPrice()).min().getAsInt();
	}

	public void printItems() {
		for (Item item : items.values()) {
			System.out.println(item);
		}
	}

	public boolean isItemSoldOut(String itemName) {
		if (items.get(itemName).isSoldOut()) {
			return true;
		}
		return false;
	}

	public boolean isAllItemSoldOut() {
		for (Item item : items.values()) {
			if (!item.isSoldOut()) {
				return false;
			}
		}
		return true;
	}

}
