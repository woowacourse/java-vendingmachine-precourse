package vendingmachine.Model;

import java.util.LinkedHashMap;

public class VendingMachine {
	private CoinGroup coins;
	private BeverageGroup beverageGroup;
	private Money userMoney;

	public void initiateCoins(Money money) {
		coins = new CoinGroup(money);
	}

	public void initiateBeverages(BeverageGroup beverages) {
		this.beverageGroup = beverages;
	}

	public void initiateUserMoney(Money money) {
		userMoney = money;
	}

	public CoinGroup getCoins() {
		return coins;
	}

	public Beverage getBeverage(String name) {
		return beverageGroup.getBeverage(name);
	}

	public Money getUserMoney() {
		return userMoney;
	}

	public int getUserMoneyInt() {
		return userMoney.get();
	}

	public int getMinPrice() {
		return beverageGroup.getMinPrice();
	}

	public LinkedHashMap<Integer, Integer> getCoinMap() {
		return coins.getIntegerMap();
	}

	public void sell(String name) {
		userMoney.setMinus(beverageGroup.getBeverage(name).price);
		beverageGroup.getBeverage(name).sell();
	}

	public boolean isActivateEnd() {
		return userMoney.get() < beverageGroup.getMinPrice() || beverageGroup.isAllSoldOut();
	}
}
