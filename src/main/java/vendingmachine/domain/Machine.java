package vendingmachine.domain;

import java.util.Iterator;
import java.util.Map;

public class Machine {
	private Coins coins;
	private Coins change;
	private Merchandise merchandise = new Merchandise();
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
			merchandise.addItem(item);
		}
	}

	public void setPayment(String payment) {
		this.balance = Integer.parseInt(payment);
	}

	public int getCurrentBalance() {
		return balance;
	}

	public boolean isExistItem(String item) {
		return merchandise.isExistItem(item);
	}

	public void buyItem(String name) {
		Item item = merchandise.findItem(name);
		if (item.checkAbleToSell(balance)) {
			balance = item.sell(balance);
		}
	}

	public boolean checkAbleToBuyItem() {
		if (merchandise.isAllSoldOut() || merchandise.isMinPriceMoreThanBalance(balance)) {
			return false;
		}
		return true;
	}

	public Map<Integer, Integer> getReturnCoins() {
		change = new Coins();
		calcChange(coins.getSortedCoinCount());
		return change.getSortedCoinCount();
	}

	private void calcChange(Map<Integer, Integer> sortedCoinCount) {
		Iterator<Integer> coins = sortedCoinCount.keySet().iterator();
		while (coins.hasNext() && balance > 0) {
			int coin = coins.next();
			int count = getReturnCoinCount(coin);
			if (count != 0) {
				balance -= coin * count;
				moveCoinsToChange(coin, count);
			}
		}
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
