package vendingmachine.Model;

import java.util.Arrays;

public class ChangesCoinGroup extends CoinGroup {
	private final CoinGroup machineCoins;
	private int userMoney;

	public ChangesCoinGroup(VendingMachine vendingMachine) {
		super();
		this.machineCoins = vendingMachine.getCoins();
		this.userMoney = vendingMachine.getUserMoney().get();
	}

	public void setRepeat() {
		Arrays.stream(Coin.values()).forEach(this::set);
	}

	private void set(Coin coin) {
		if (isNoStockLimit(coin)) {
			setOne(coin, machineCoins.getStock(coin));
			return;
		}
		setOne(coin, userMoney / coin.getAmount());
	}

	private boolean isNoStockLimit(Coin coin) {
		return (userMoney / coin.getAmount()) > machineCoins.getStock(coin);
	}

	private void setOne(Coin coin, int coinCount) {
		set(coin, coinCount);
		userMoney -= coin.getAmount() * coinCount;
	}
}
