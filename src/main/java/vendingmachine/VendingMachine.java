package vendingmachine;

import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VendingMachine {
	private List<Coin> coins = new ArrayList<>();

	private void addCountInCoins(List<Coin> coinList, int coinValue) {
		for (Coin coin : coinList) {
			if (coin.sameValue(coinValue)) {
				coin.addCount(1);
			}
		}
	}

	private int generateRandomCoin() {
		List<Integer> coins = new ArrayList<>();
		for (Coin coin : Coin.values()) {
			coins.add(coin.getValue());
		}
		return pickNumberInList(coins);
	}

	public List<Coin> generateRemainCoins(int remains) {
		List<Coin> coinList = Arrays.asList(Coin.values());
		while (remains != 0) {
			int newCoin = generateRandomCoin();
			if (remains < newCoin) {
				continue;
			}
			remains -= newCoin;
			addCountInCoins(coinList, newCoin);
		}
		coins = coinList;
		return coins;
	}

	public void buyItem(String itemName, Items items, UserMoney userMoney) {
		try {
			Item item = items.hasItem(itemName);
			item.sellItem(userMoney);
		} catch (IllegalArgumentException e) {}
	}

	public boolean canNotBuyAnything(UserMoney userMoney, Items items) {
		return userMoney.canNotBuy(items.minPrice()) || items.allOutOfStock();
	}

	public HashMap<Integer, Integer> returnChange(UserMoney userMoney) {
		HashMap<Integer, Integer> change = new HashMap<>();
		int coinCount;
		for (Coin coin : this.coins) {
			coinCount = coin.toChange(userMoney);
			if (coinCount > 0) {
				change.put(coin.getValue(), coinCount);
			}
		}
		return change;
	}
}
