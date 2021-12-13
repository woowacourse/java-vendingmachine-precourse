package vendingmachine.Model;

public class VendingMachine {
	public final CoinGroup coins;
	public final BeverageGroup beverages;
	public final Money userMoney;

	public VendingMachine(CoinGroup coins, BeverageGroup beverages, Money userMoney) {
		this.coins = coins;
		this.beverages = beverages;
		this.userMoney = userMoney;
	}

	public void sell(String name) {
		userMoney.spend(beverages.findPrice(name));
		beverages.minusOneStock(name);
	}

	public boolean isActivateEnd() {
		return !userMoney.isBiggerOrSame(beverages.getMinPrice()) || beverages.isAllSoldOut();
	}
}
