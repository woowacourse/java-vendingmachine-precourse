package vendingmachine.domain;

import java.util.EnumMap;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.view.OutputView;

public class CoinBox {
	private int holdingAmount;
	private EnumMap<Coin, Integer> coinEnumMap = new EnumMap<>(Coin.class);

	CoinBox(int holdingAmount) {
		this.holdingAmount = holdingAmount;
		coinEnumMap.put(Coin.COIN_500, 0);
		coinEnumMap.put(Coin.COIN_100, 0);
		coinEnumMap.put(Coin.COIN_50, 0);
		coinEnumMap.put(Coin.COIN_10, 0);
		makeCoins();
	}

	public void showCoins() {
		coinEnumMap.forEach((coin, numberOfCoin) -> OutputView.printCoinInfo(coin.toString(), numberOfCoin));
	}

	public void returnChanges(int amount) {
		Coin[] coins = Coin.values();
		for (Coin coin : coins) {
			int number = Math.min(amount / coin.getAmount(), coinEnumMap.get(coin));
			if (number > 0) {
				OutputView.printCoinInfo(coin.toString(), number);
				amount -= coin.getAmount() * number;
			}
		}
	}

	private void makeCoins() {
		int amount = holdingAmount;
		while (amount > 0) {
			int randomCoinAmount = pickRandomCoinAmount(amount);
			amount -= randomCoinAmount;
			Coin coin = Coin.from(randomCoinAmount);
			int beforeCoinAmount = coinEnumMap.get(coin);
			coinEnumMap.replace(coin, beforeCoinAmount + 1);
		}
	}

	private int pickRandomCoinAmount(int amountLimit) {
		return Randoms.pickNumberInList(Coin.getAmountList(amountLimit));
	}
}
