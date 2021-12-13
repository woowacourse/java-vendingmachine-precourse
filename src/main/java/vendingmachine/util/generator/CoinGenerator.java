package vendingmachine.util.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.Coin;
import vendingmachine.util.supporter.MapSupporter;

public class CoinGenerator {
	public static SortedMap<Coin, Integer> generate(List<Integer> coinValues, Integer totalCoin) {
		SortedMap<Coin, Integer> coins = new TreeMap<>((c1, c2) -> c2.getAmount() - c1.getAmount());
		List<Coin> coinList = new ArrayList<>(Arrays.asList(Coin.COIN_500, Coin.COIN_100, Coin.COIN_50, Coin.COIN_10));
		while (totalCoin > 0) {
			int randomCoin = Randoms.pickNumberInList(coinValues);
			if (randomCoin > totalCoin) {
				continue;
			}
			coinList.remove(Coin.getCoin(randomCoin));
			MapSupporter.increaseCoinCount(coins, Coin.getCoin(randomCoin), 0, 1);
			totalCoin -= randomCoin;
		}
		putNoCoins(coins, coinList);
		return coins;
	}

	private static void putNoCoins(SortedMap<Coin, Integer> coins, List<Coin> coinList) {
		for (Coin coin : coinList) {
			coins.put(coin, 0);
		}
	}
}
