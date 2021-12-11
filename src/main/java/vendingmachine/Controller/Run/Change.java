package vendingmachine.Controller.Run;

import vendingmachine.Model.Coin;
import vendingmachine.Model.CoinWallet;
import vendingmachine.Model.VendingMachine;
import vendingmachine.View.OutputView;

public class Change {
	private final CoinWallet changeCoins = new CoinWallet();
	private final CoinWallet machineCoins;
	private int userMoney;

	public Change(VendingMachine vendingMachine) {
		this.machineCoins = vendingMachine.machineCoins;
		this.userMoney = vendingMachine.userMoney;
		OutputView.printUserMoney(userMoney);
		setChangeCoins();
		OutputView.printChange(changeCoins);
	}

	private void setChangeCoins() {
		for (Coin coin : Coin.values()) {
			setCoin(coin);
		}
	}

	private void setCoin(Coin coin) {
		if (isNoMaxCount(coin)) {
			setOneCoin(coin, machineCoins.getNum(coin));
			return;
		}
		setOneCoin(coin, userMoney / coin.getAmount());
	}

	private boolean isNoMaxCount(Coin coin) {
		return (userMoney / coin.getAmount()) > machineCoins.getNum(coin);
	}

	private void setOneCoin(Coin coin, int coinCount) {
		changeCoins.set(coin, coinCount);
		userMoney -= coin.getAmount() * coinCount;
	}
}
