package vendingmachine.model;

import vendingmachine.service.OrderService;
import vendingmachine.service.SettingMoneyService;

public class VendingMachine {
	private int insertedMoney;
	private Changes changes;
	private Menu menu;

	public VendingMachine() {
		insertedMoney = 0;
		changes = new Changes();
	}

	public void setCoins(String initCoin) {
		changes.setCoinList(initCoin);
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
		insertedMoney -= OrderService.takeOrder(this, orderedMenu);
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
		return changes.giveChanges(coin);
	}

}
