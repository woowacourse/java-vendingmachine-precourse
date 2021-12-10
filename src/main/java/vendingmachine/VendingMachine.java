package vendingmachine;

import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class VendingMachine {
	private List<Coin> coins;

	public static int generateRandomCoin() {
		List<Integer> coins = new ArrayList<>();
		for (Coin coin : Coin.values()) {
			coins.add(coin.getValue());
		}
		return pickNumberInList(coins);
	}

	public static void addCountInCoins(List<Coin> coinList, int coinValue) {
		for (Coin coin : coinList) {
			if (coin.getValue() == coinValue) {
				coin.addCount();
			}
		}
	}

	public static void main(String[] args) {
		VendingMachine machine = new VendingMachine();
		machine.generateRemainCoins(3000);
		System.out.println(machine.coins.get(0).getCount());
		System.out.println(machine.coins.get(1).getCount());
		System.out.println(machine.coins.get(2).getCount());
		System.out.println(machine.coins.get(3).getCount());
		UserMoney userMoney = new UserMoney(1200);
		HashMap<Integer, Integer> change;
		change = machine.returnChange(userMoney);
		System.out.println(change.entrySet());
	}

	public List<Coin> getCoins() {
		return this.coins;
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
		this.coins = coinList;
		return coinList;
	}

	public void buyItem(String itemName, Items items, UserMoney userMoney) {
		Item item = items.hasItem(itemName);
		item.sellItem();
		userMoney.subtractUserMoney(item.getPrice());
	}

	public boolean canNotBuyAnything(UserMoney userMoney, Items items) {
		return userMoney.getMoney() < items.minPrice() || items.allOutOfStock();
	}

	public HashMap<Integer, Integer> returnChange(UserMoney userMoney) {
		HashMap<Integer, Integer> change = new HashMap<>();
		int coinCount;
		for (Coin coin : this.coins) {
			System.out.println(coin.getValue());
			coinCount = 0;
			while (coin.getCount() > 0) {
				if (userMoney.getMoney() >= coin.getValue()) {
					userMoney.subtractUserMoney(coin.getValue());
					coin.subCount();
					coinCount++;
				} else {
					break;
				}
			}
			if (coinCount > 0) {
				change.put(coin.getValue(), coinCount);
			}
		}
		return change;
	}
}
