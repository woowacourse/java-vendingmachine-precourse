package vendingmachine.Controller.Run;

import java.util.LinkedHashMap;

import vendingmachine.Model.Coin;
import vendingmachine.View.OutputView;

public class Change {
	private final LinkedHashMap<Coin, Integer> changeCoins = new LinkedHashMap<>();

	public Change() {
		OutputView.printUserMoney(Init.userMoney);
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
			setOneCoin(coin, Init.machineCoins.get(coin));
			return;
		}
		setOneCoin(coin, Init.userMoney / coin.getAmount());
	}

	private boolean isNoMaxCount(Coin coin) {
		return (Init.userMoney / coin.getAmount()) > Init.machineCoins.get(coin);
	}

	private void setOneCoin(Coin coin, int coinCount) {
		changeCoins.put(coin, coinCount);
		Init.userMoney -= coin.getAmount() * coinCount;
	}
}
