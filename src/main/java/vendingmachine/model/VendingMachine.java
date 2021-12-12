package vendingmachine.model;

import vendingmachine.service.SettingMoneyService;
import vendingmachine.service.TakingOrderService;

public class VendingMachine {
	private int insertedMoney;
	private Changes changes;
	private Menu menu;

	public VendingMachine() {
		insertedMoney = 0;
	}

	public void setCoins(String initCoin) {
		changes = new Changes(initCoin);
	}

	public int countCoin(Coin coin) {
		return changes.countCoin(coin);
	}

	public void setMenu(String productInfo) {
		menu = new Menu(productInfo);
	}

	public void insertMoney(String insertedMoney) {
		this.insertedMoney = SettingMoneyService.setMoney(insertedMoney);
	}

	public void takeOrder(String orderedMenu) {
		insertedMoney -= TakingOrderService.takeOrder(this, orderedMenu);
	}

	public boolean findMenu(String order) {
		return menu.findMenu(order);
	}

	public boolean findQuantityOfOrder(String order) {
		return menu.findQuantity(order);
	}

	public int comparePrice(String order) {
		return menu.comparePrice(order, insertedMoney);
	}

	public int getRemainMoney() {
		return insertedMoney;
	}

	public boolean stopMachine() {
		return menu.stopOrdering(insertedMoney);
	}

	public int giveChanges(Coin coin) {
		int coinNum = changes.give(coin, insertedMoney);
		insertedMoney -= coin.getAmount() * coinNum;
		return coinNum;
	}

}
