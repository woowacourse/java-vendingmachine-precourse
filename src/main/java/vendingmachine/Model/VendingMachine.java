package vendingmachine.Model;

import java.util.ArrayList;

public class VendingMachine {
	private CoinGroup coins;
	private final BeverageGroup beverageGroup = new BeverageGroup();
	private int userMoney;

	public void initCoins(int money) {
		coins = new CoinGroup(money);
	}

	public void initBeverage(ArrayList<Object[]> beverages) {
		for (Object[] values : beverages) {
			this.beverageGroup.add(new Beverage(values));
		}
	}

	public void initUserMoney(int money) {
		userMoney = money;
	}

	public CoinGroup getCoins() {
		return coins;
	}

	public String[] getNames() {
		return beverageGroup.getNames();
	}

	public Beverage getBeverage(String name) {
		return beverageGroup.getBeverages(name);
	}

	public int getUserMoney() {
		return userMoney;
	}

	public void sell(String name) {
		userMoney -= beverageGroup.getBeverages(name).price;
		beverageGroup.getBeverages(name).sell();
	}

	public boolean isActivateEnd() {
		return userMoney < beverageGroup.getMinPrice() || beverageGroup.isAllSoldOut();
	}
}
