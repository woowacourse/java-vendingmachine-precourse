package vendingmachine.Model;

import java.util.ArrayList;

public class VendingMachine {
	private CoinGroup coins;
	private final BeverageGroup beverageGroup = new BeverageGroup();
	private Money userMoney;

	public void initCoins(int money) {
		coins = new CoinGroup(money);
	}

	public void initBeverage(ArrayList<Object[]> beverages) {
		for (Object[] values : beverages) {
			this.beverageGroup.add(new Beverage(values));
		}
	}

	public void initUserMoney(int money) {
		userMoney = new Money(money);
	}

	public CoinGroup getCoins() {
		return coins;
	}

	public String[] getNames() {
		return beverageGroup.getNames();
	}

	public Beverage getBeverage(String name) {
		return beverageGroup.getBeverage(name);
	}

	public Money getUserMoney() {
		return userMoney;
	}

	public void sell(String name) {
		userMoney.setMinus(beverageGroup.getBeverage(name).price.get());
		beverageGroup.getBeverage(name).sell();
	}

	public boolean isActivateEnd() {
		return userMoney.get() < beverageGroup.getMinPrice() || beverageGroup.isAllSoldOut();
	}
}
