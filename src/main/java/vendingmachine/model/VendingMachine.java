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
		insertedMoney -= Order.takeOrder(this);
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

}
