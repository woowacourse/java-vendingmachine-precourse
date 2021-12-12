package vendingmachine.Model;

public class VendingMachine {
	private CoinGroup coins;
	private BeverageGroup beverageGroup;
	private Money userMoney;

	public void initCoins(Money money) {
		coins = new CoinGroup(money);
	}

	public void initBeverages(BeverageGroup beverages) {
		this.beverageGroup = beverages;
	}

	public void initUserMoney(Money money) {
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

	public int getMinPrice() {
		return beverageGroup.getMinPrice();
	}

	public void sell(String name) {
		userMoney.setMinus(beverageGroup.getBeverage(name).price);
		beverageGroup.getBeverage(name).sell();
	}

	public boolean isActivateEnd() {
		return userMoney.get() < beverageGroup.getMinPrice() || beverageGroup.isAllSoldOut();
	}
}
