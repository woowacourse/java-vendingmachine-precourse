package vendingmachine.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Item;
import vendingmachine.util.Symbol;

public class VendingMachine {
	private final HashMap<Coin, Integer> coins;
	private final ArrayList<Item> items;

	public VendingMachine(List<Integer> coin) {
		this.coins = new HashMap<>();
		initCoins(coin);
		this.items = new ArrayList<>();
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

	public void addItem(Item item) {
		items.add(item);
	}

	public int getMinItemPrice() {
		return items.stream().mapToInt(i -> i.getPrice()).min().getAsInt();
	}

	public boolean isAllItemSoldOut() {
		for (Item item : items) {
			if(!item.isSoldOut()){
				return false;
			}
		}
		return true;
	}

}
