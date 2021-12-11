package vendingmachine.domain;

import java.util.List;
import java.util.Map;

import vendingmachine.Validation;

public class VendingMachine {
	private static final int NAME = 0;
	private static final int PRICE = 1;
	private static final int QUANTITY = 2;

	private Coins coins;
	private Items items;

	public void initializeCoins(String input) {
		int coinBalance = Validation.isValidBalance(input);
		this.coins = new Coins(coinBalance);
		coins.createRandomCoins();
	}

	public void initializeItems(String input) {
		this.items = new Items();
		List<String> itemsInfo = Validation.isValidItems(input);
		for (String itemInfo : itemsInfo) {
			List<String> detail = Validation.isValidItem(itemInfo);
			items.add(new Item(detail.get(NAME), detail.get(PRICE), detail.get(QUANTITY)));
		}
	}

	public Map<Coin, Integer> getCoins() {
		return coins.getCoins();
	}
}
