package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Machine {
	private Coins coins;
	private Coins change;
	private List<Merchandise> merchandiseList = new ArrayList<>();
	private int balance;

	public void setCoins(int amount) {
		coins = new Coins(amount);
		coins.pickCoins();
	}

	public Map<Integer, Integer> getCoinList() {
		return coins.getSortedCoinCount();
	}

	public void setMerchandise(String merchandiseList) {
		String[] items = merchandiseList.split(";");
		for (String item : items) {
			this.merchandiseList.add(new Merchandise(item));
		}
	}

	public void setPayment(String payment) {
		this.balance = Integer.parseInt(payment);
	}

	public int getCurrentBalance() {
		return balance;
	}

	public boolean isExistItem(String item) {
		for (Merchandise merchandise : merchandiseList) {
			if (merchandise.isSameMerchandise(item)) {
				return true;
			}
		}
		return false;
	}

	public void buyItem(String name) {
		Merchandise item = findItem(name);
		if (item.checkAbleToSell(balance)) {
			balance = item.sell(balance);
		}
	}

	private Merchandise findItem(String name) {
		return merchandiseList.stream()
			.filter(merchandise -> merchandise.isSameMerchandise(name))
			.findAny()
			.orElse(null);
	}

	public boolean checkAbleToBuyItem() {
		if (checkItemsCount() && checkBalance()) {
			return true;
		}
		return false;
	}

	private boolean checkItemsCount() {
		for (Merchandise merchandise : merchandiseList) {
			if (merchandise.isSoldOut()) {
				return false;
			}
		}
		return true;
	}

	private boolean checkBalance() {
		Collections.sort(merchandiseList);
		if (merchandiseList.get(0).checkAbleToSell(balance) == false) {
			return false;
		}
		return true;
	}

	public Map<Integer, Integer> getReturnCoins() {
		change = new Coins();
		Map<Integer, Integer> sortedCoinCount = coins.getSortedCoinCount();
		Iterator<Integer> coins = sortedCoinCount.keySet().iterator();
		while (coins.hasNext() && balance > 0) {
			int coin = coins.next();
			int count = getReturnCoinCount(coin);
			if (count != 0) {
				balance -= coin * count;
				moveCoinsToChange(coin, count);
			}
		}
		return change.getSortedCoinCount();
	}

	private int getReturnCoinCount(int coin) {
		int count = balance / coin;
		if (coins.getCoinCount(coin) < count) {
			count = coins.getCoinCount(coin);
		}
		return count;
	}

	private void moveCoinsToChange(int coin, int count) {
		coins.changeCoinCount(coin, coins.getCoinCount(coin) - count);
		change.changeCoinCount(coin, count);
	}

}
