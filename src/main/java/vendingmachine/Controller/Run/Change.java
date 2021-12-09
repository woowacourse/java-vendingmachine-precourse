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
			int divisor = coin.getAmount();
			int coinCount = Init.machineCoins.get(coin);

			if ((Init.userMoney / divisor) > coinCount) {
				changeCoins.put(coin, coinCount);
				Init.userMoney -= coinCount * divisor;
				continue;
			}
			changeCoins.put(coin, Init.userMoney / divisor);
			Init.userMoney %= divisor;
		}
	}
}
