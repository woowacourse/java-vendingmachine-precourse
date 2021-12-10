package vendingmachine.Controller.Run;

import vendingmachine.Model.Coin;
import vendingmachine.Model.CoinWallet;
import vendingmachine.View.OutputView;

public class Change {
	private final CoinWallet changeCoins = new CoinWallet();
	private final CoinWallet machineCoins;

	public Change(CoinWallet machineCoins, int userMoney) {
		this.machineCoins = machineCoins;
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
		setOneCoin(coin, Init.userMoney / coin.getAmount());
	}

	private boolean isNoMaxCount(Coin coin) {
		return (Init.userMoney / coin.getAmount()) > machineCoins.getNum(coin);
	}

	private void setOneCoin(Coin coin, int coinCount) {
		changeCoins.set(coin, coinCount);
		Init.userMoney -= coin.getAmount() * coinCount;
	}
}
