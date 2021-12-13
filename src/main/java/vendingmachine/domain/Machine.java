package vendingmachine.domain;

import java.util.List;
import java.util.Map;

public class Machine {
	private Coins coins;
	private Merchandise merchandise = new Merchandise();
	private int balance;

	public void setCoins(int amount) {
		coins = new Coins(amount);
	}

	public Map<Integer, Integer> getCoinList() {
		return coins.getSortedCoinCount();
	}

	public void setMerchandise(List<String> merchandise) {
		for (String item : merchandise) {
			this.merchandise.add(item);
		}
	}

	public void setPayment(String payment) {
		this.balance = Integer.parseInt(payment);
	}

	public int getCurrentBalance() {
		return balance;
	}

	public boolean isValidItem(String name) {
		return merchandise.isExistItem(name)
			&& merchandise.findItem(name).isSoldOut() == false;
	}

	public void buyItem(String name) {
		Item item = merchandise.findItem(name);
		if (item.checkAbleToSell(balance)) {
			balance = item.sell(balance);
		}
	}

	public boolean checkAbleToBuyItem() {
		Item cheapestItem = merchandise.getLowPriceItemAmongRemainingItems();
		if (merchandise.isAllSoldOut() || cheapestItem.isNotEnoughMoney(balance)) {
			return false;
		}
		return true;
	}

	public Map<Integer, Integer> getReturnChange() {
		return coins.returnToMinCount(balance);
	}

}
