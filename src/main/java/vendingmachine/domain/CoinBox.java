package vendingmachine.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.view.OutputView;

public class CoinBox {
	private int holdingMoney;
	private EnumMap<Coin, Integer> coinIntegerEnumMap = new EnumMap<Coin, Integer>(Coin.class);

	CoinBox(int holdingMoney) {
		this.holdingMoney = holdingMoney;
		coinIntegerEnumMap.put(Coin.COIN_500, 0);
		coinIntegerEnumMap.put(Coin.COIN_100, 0);
		coinIntegerEnumMap.put(Coin.COIN_50, 0);
		coinIntegerEnumMap.put(Coin.COIN_10, 0);
		makeCoins();
	}

	private void makeCoins() {
		int money = holdingMoney;
		while (money > 0) {
			int randomCoinAmount = pickRandomCoinAmount(money);
			money -= randomCoinAmount;
			Coin coin = Coin.getCoinByAmount(randomCoinAmount);
			int beforeCoinAmount = coinIntegerEnumMap.get(coin);
			coinIntegerEnumMap.replace(coin, beforeCoinAmount + 1);
		}
	}

	private int pickRandomCoinAmount(int money) {
		List<Integer> coinAmountList = Arrays.asList(10, 50, 100, 500);
		int randomCoinAmount = Randoms.pickNumberInList(coinAmountList.stream()
			.filter(coinAmount -> coinAmount <= money)
			.collect(Collectors.toList()));
		return randomCoinAmount;
	}
}
