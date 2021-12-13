package vendingmachine.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import vendingmachine.utils.Message;

public class VendingMachine {

	private static VendingMachine vendingMachine = null;

	public int holdingMoney = 0;
	public int inputMoney = 0;
	public ArrayList<Item> holdingItemList;
	public LinkedHashMap<Coin, Integer> holdingCoins;
	public LinkedHashMap<Coin, Integer> changeCoins;

	private Coins coins;

	public VendingMachine vendingMachine() {
		if (this.vendingMachine == null) {
			VendingMachine vendingMachine = new VendingMachine();
		}
		return vendingMachine;
	}

	public LinkedHashMap<Coin, Integer> makeCoins() {
		coins = new Coins(holdingMoney);
		this.holdingCoins = coins.getCoins();
		return holdingCoins;
	}

	public void stockDeduct(String buyItem) {
		for (int i = 0; i < holdingItemList.size(); i++) {
			if (holdingItemList.get(i).getName().equals(buyItem)) {
				holdingItemList.get(i).setStock(holdingItemList.get(i).getStock() - 1);
			}
		}
	}

	public void inputMoneyDeduct(String buyItem) {
		for (int i = 0; i < this.holdingItemList.size(); i++) {
			if (this.holdingItemList.get(i).getName().equals(buyItem)) {
				this.inputMoney -= this.holdingItemList.get(i).getPrice();
			}
		}
	}

	public void calculateChangeCoins() {
		Changes changes = new Changes();
		this.changeCoins = changes.returnChange(holdingCoins, inputMoney);
	}

	public void nonExistItemError(String buyItem) {
		boolean isExistedItem = false;
		for (int i = 0; i < holdingItemList.size(); i++) {
			if (holdingItemList.get(i).getName().equals(buyItem)) {
				isExistedItem = true;
			}
		}
		if (isExistedItem == false) {
			throw new IllegalArgumentException(Message.NON_EXIST_ITEM_ERROR);
		}
	}

	public void nonEnoughMoneyError(String buyItem) {
		for (int i = 0; i < holdingItemList.size(); i++) {
			if (holdingItemList.get(i).getName().equals(buyItem) && holdingItemList.get(i).getPrice() > inputMoney) {
				throw new IllegalArgumentException(Message.NON_ENOUGH_MONEY_ERROR);
			}
		}
	}

	public boolean isAvailableKeepBuyingAboutPrice() {
		boolean isAvailableKeepBuyingAboutPrice = false;
		for (int i = 0; i < holdingItemList.size(); i++) {
			if (holdingItemList.get(i).getPrice() <= inputMoney) {
				isAvailableKeepBuyingAboutPrice = true;
			}
		}
		return isAvailableKeepBuyingAboutPrice;
	}

	public boolean isAvailableKeepBuyingAboutStock() {
		boolean isAvailableKeepBuyingAboutStock = false;
		for (int i = 0; i < holdingItemList.size(); i++) {
			if (holdingItemList.get(i).getStock() > 0) {
				isAvailableKeepBuyingAboutStock = true;
			}
		}
		return isAvailableKeepBuyingAboutStock;
	}

	public boolean isPurchasableItem(String buyItem) {
		boolean isPurchasableItem = true;
		try {
			nonExistItemError(buyItem);
			nonEnoughMoneyError(buyItem);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			isPurchasableItem = false;
		}
		return isPurchasableItem;
	}

	public String inputMoneyToString() {
		return inputMoney + "원";
	}
}
