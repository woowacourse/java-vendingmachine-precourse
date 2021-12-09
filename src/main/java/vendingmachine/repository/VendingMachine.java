package vendingmachine.repository;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Item;
import vendingmachine.util.InputCondition;
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

	public int buyItemAndGetPrice(String itemName) {
		Item item = items.get(itemName);
		item.decreaseQuantity();
		return item.getPrice();
	}

	public int subtractCoins(int payMoney) {
		List<Coin> reverseSortedList = coins.keySet()
			.stream()
			.sorted((c1, c2) -> -1 * Integer.compare(c1.getAmount(), c2.getAmount()))
			.collect(Collectors.toList());
		for (Coin coin : reverseSortedList) {
			payMoney = subtract(coin, payMoney);
		}
		return payMoney;
	}

	private int subtract(Coin coin, int payMoney) {
		while (payMoney >= coin.getAmount() && coins.get(coin) > InputCondition.ZERO) {
			coins.put(coin, coins.get(coin) - 1);
			payMoney -= coin.getAmount();
		}
		return payMoney;
	}

	public void printCoins() {
		for (Coin coin : coins.keySet()) {
			System.out.printf("%s : %s\n", coin, coins.get(coin));
		}
	}

}
