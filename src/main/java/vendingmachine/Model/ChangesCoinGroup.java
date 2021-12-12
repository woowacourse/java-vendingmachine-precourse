package vendingmachine.Model;

import java.util.Arrays;

public class ChangesCoinGroup extends CoinGroup {
	private final CoinGroup changeCoins;
	private final Money userMoney;

	public ChangesCoinGroup(VendingMachine vendingMachine) {
		super();
		this.changeCoins = vendingMachine.getCoins();
		this.userMoney = vendingMachine.getUserMoney();
		setAllCoins();
	}

	public void setAllCoins() {
		Arrays.stream(Coin.values()).forEach(this::setThisValueCoins);
	}

	private void setThisValueCoins(Coin coin) {
		if (isNoStockLimit(coin)) {
			moneyToCoin(coin, changeCoins.getStock(coin));
			return;
		}
		moneyToCoin(coin, userMoney.toCoinCount(coin.getAmount()));
	}

	private boolean isNoStockLimit(Coin coin) {
		return userMoney.toCoinCount(coin.getAmount()) > changeCoins.getStock(coin);
	}

	private void moneyToCoin(Coin coin, int coinCount) {
		set(coin, coinCount);
		userMoney.setMinus(coin.getAmount() * coinCount);
	}
}
