package vendingmachine.domain;

import java.util.HashMap;
import java.util.List;

public class VendingMachine {
	public int holdingMoney;
	public int inputMoney;
	public List<Item> itemList;
	public HashMap<Coin, Integer> coinCount;

	public VendingMachine(int holdingMoney, int inputMoney, List<Item> itemList, HashMap<Coin, Integer> coinCount) {
		this.holdingMoney = holdingMoney;
		this.inputMoney = inputMoney;
		this.itemList = itemList;
		this.coinCount = coinCount;
	}

	public void minusInputMoney(int itemPrice) {
		inputMoney -= itemPrice;
	}

	public HashMap<Coin, Integer> calculateChange() {
		int money = inputMoney;
		HashMap<Coin, Integer> change = initChange();
		for (Coin coin : Coin.getCoinArray()) {
			if (money / coin.getAmount() > 0 && money / coin.getAmount() <= coinCount.get(coin)) {
				change.put(coin, money / coin.getAmount());
				coinCount.put(coin, coinCount.get(coin) - money / coin.getAmount());
				money %= coin.getAmount();
			} else if (money / coin.getAmount() > 0 && money / coin.getAmount() > coinCount.get(coin)) {
				change.put(coin, coinCount.get(coin));
				coinCount.put(coin, 0);
				money -= coin.getAmount() * coinCount.get(coin);
			}
		}
		return change;
	}

	public HashMap<Coin, Integer> initChange() {
		HashMap<Coin, Integer> change = new HashMap<>();
		for (Coin coin : Coin.getCoinArray()) {
			change.put(coin, 0);
		}
		return change;
	}

	public boolean checkEmptyItemList() {
		if (itemList.size() == 0) {
			return true;
		}
		return false;
	}

	public boolean checkBuyingPossible() {
		for (Item item : itemList) {
			if (inputMoney >= item.price) {
				return true;
			}
		}
		return false;
	}

	public boolean checkExcessMoney(int itemPrice) {
		if (inputMoney - itemPrice >= 0) {
			return true;
		}
		throw new IllegalArgumentException();
	}
}
