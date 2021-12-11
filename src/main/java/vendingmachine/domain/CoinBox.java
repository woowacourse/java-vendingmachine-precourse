package vendingmachine.domain;

import java.util.EnumMap;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.view.OutputView;

public class CoinBox {
	private int holdingMoney;
	private EnumMap<Coin, Integer> coinEnumMap = new EnumMap<>(Coin.class);

	CoinBox(int holdingMoney) {
		this.holdingMoney = holdingMoney;
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
		int money = holdingMoney;
		while (money > 0) {
			int randomCoinAmount = pickRandomCoinAmount(money);
			money -= randomCoinAmount;
			Coin coin = Coin.getCoinByAmount(randomCoinAmount);
			int beforeCoinAmount = coinEnumMap.get(coin);
			coinEnumMap.replace(coin, beforeCoinAmount + 1);
		}
	}

	private int pickRandomCoinAmount(int money) {
		return Randoms.pickNumberInList(Coin.getAmountList(money));
	}
}
