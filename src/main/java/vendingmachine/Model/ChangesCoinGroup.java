package vendingmachine.Model;

import java.util.Arrays;

public class ChangesCoinGroup extends CoinGroup {
	private final Money userMoney;

	public ChangesCoinGroup(CoinGroup coins, Money userMoney) {
		super(coins);
		this.userMoney = userMoney;
		setAllCoins();
	}

	public void setAllCoins() {
		Arrays.stream(Coin.values()).forEach(this::setThisValueCoins);
	}

	private void setThisValueCoins(Coin coin) {
		if (isNoStockLimit(coin)) {
			moneyToCoin(coin, getStock(coin));
			return;
		}
		moneyToCoin(coin, userMoney.toCoinCount(coin.getAmount()));
	}

	private boolean isNoStockLimit(Coin coin) {
		return userMoney.toCoinCount(coin.getAmount()) > getStock(coin);
	}

	private void moneyToCoin(Coin coin, int coinCount) {
		coins.put(coin, coinCount);
		userMoney.spend(coin.getAmount() * coinCount);
	}
}
