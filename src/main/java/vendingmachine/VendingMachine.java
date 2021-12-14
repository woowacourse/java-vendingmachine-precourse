package vendingmachine;

import java.util.Arrays;
import java.util.HashMap;

import camp.nextstep.edu.missionutils.Randoms;

public class VendingMachine {
	private final static String SPLIT_REGEX = ",";
	private final static String INPUT_ITEM_SPLIT_REGEX = ";";
	private final static String REPLACE_TARGET_LEFT = "[";
	private final static String REPLACE_TARGET_RIGHT = "]";

	private final HashMap<Coin, Integer> coins;
	private final HashMap<String, Item> items;
	private int userAmount;

	public VendingMachine() {
		coins = new HashMap<>();
		items = new HashMap<>();
	}

	public void setCoins(int amount) {
		for (Coin coin : Coin.values()) {
			coins.put(coin, 0);
		}

		do {
			int randomCoinAmount = Randoms.pickNumberInList(Coin.getCoinValueList());
			if (amount - randomCoinAmount >= 0) {
				coins.computeIfPresent(Coin.valueOf(randomCoinAmount), (k, v) -> v + 1);
				amount -= randomCoinAmount;
			}
		} while (amount > 0);
	}

	public HashMap<Coin, Integer> getCoins() {
		return coins;
	}

	public void calculateReturnCoin(HashMap<Coin, Integer> returnCoins, Coin coin) {
		int returnCoinNumber = 0;
		for (int i = 0; i < coins.get(coin); i++) {
			if (userAmount - coin.getAmount() >= 0) {
				returnCoinNumber++;
				userAmount -= coin.getAmount();
			}
		}
		if (returnCoinNumber > 0) {
			returnCoins.put(coin, returnCoinNumber);
		}
	}

	public void setItems(String inputItem) {
		String[] itemStrings = inputItem.split(INPUT_ITEM_SPLIT_REGEX);
		for (String itemString : itemStrings) {
			itemString = itemString.replace(REPLACE_TARGET_LEFT, "").replace(REPLACE_TARGET_RIGHT, "");
			String[] itemInfos = itemString.split(SPLIT_REGEX);
			items.put(itemInfos[0], new Item(itemInfos));
		}
	}

	public HashMap<String, Item> getItems() {
		return items;
	}

	public void setUserAmount(int userAmount) {
		this.userAmount = userAmount;
	}

	public void reduceUserAmount(int amount) {
		userAmount -= amount;
	}

	public int getUserAmount() {
		return userAmount;
	}

	public boolean checkRemainUserAmount() {
		Integer[] prices = items.values().stream()
			.map(Item::getPrice)
			.toArray(Integer[]::new);

		Arrays.sort(prices);

		return userAmount >= prices[0];
	}

	public boolean checkRemainItemNumber() {
		for (Item item : items.values()) {
			if (item.getNumber() != 0) {
				return true;
			}
		}
		return false;
	}
}
