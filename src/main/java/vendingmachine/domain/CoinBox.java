package vendingmachine.domain;

import java.util.Arrays;
import java.util.EnumMap;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.view.OutputView;

public class CoinBox {
	private static final int NUMBER_OF_NO_COIN = 0;
	private static final int NO_REMAINING_AMOUNT = 0;

	private final EnumMap<Coin, Integer> coinEnumMap = new EnumMap<>(Coin.class);

	CoinBox(int holdingAmount) {
		Arrays.stream(Coin.values()).forEach(coin -> coinEnumMap.put(coin, NUMBER_OF_NO_COIN));
		makeCoins(holdingAmount);
	}

	public void showCoins() {
		coinEnumMap.forEach((coin, numberOfCoin) -> OutputView.printCoinInfo(coin.toString(), numberOfCoin));
	}

	public void returnChanges(int amount) {
		Coin[] coins = Coin.values();
		for (Coin coin : coins) {
			int number = Math.min(amount / coin.getAmount(), coinEnumMap.get(coin));
			if (number > NUMBER_OF_NO_COIN) {
				OutputView.printCoinInfo(coin.toString(), number);
				amount -= coin.getAmount() * number;
			}
		}
	}

	private void makeCoins(int amount) {
		while (amount > NO_REMAINING_AMOUNT) {
			int randomCoinAmount = pickRandomCoinAmount(amount);
			Coin coin = Coin.from(randomCoinAmount);
			int beforeNumberOfCoin = coinEnumMap.get(coin);
			coinEnumMap.replace(coin, beforeNumberOfCoin + 1);
			amount -= randomCoinAmount;
		}
	}

	private int pickRandomCoinAmount(int amountLimit) {
		return Randoms.pickNumberInList(Coin.getAmountList(amountLimit));
	}
}
