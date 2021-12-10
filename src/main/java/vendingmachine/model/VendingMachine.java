package vendingmachine.model;

import vendingmachine.util.Money;

public class VendingMachine {
	private int insertedMoney;
	private Changes changes;
	private Menu menu;

	public VendingMachine() {
		insertedMoney = 0;
		changes = new Changes();
		menu = new Menu();
	}

	public void setCoins() {
		changes.setCoinList();
	}

	public int countCoin(int idx) {
		return changes.countCoin(idx);
	}

	public void setMenu() {
		menu.setProductList();
	}

	public void insertMoney() {
		insertedMoney = Money.setMoney();
	}

	public void takeOrder() {
		Order.takeOrder(this);
	}

	public boolean findMenu(String order) {
		return menu.findMenu(order);
	}
}
