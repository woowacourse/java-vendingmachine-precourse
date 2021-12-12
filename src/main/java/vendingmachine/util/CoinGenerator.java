package vendingmachine.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.Coin;

public class CoinGenerator {
	public static Map<Coin, Integer> generate(List<Integer> coinValues, Integer totalCoin) {
		Map<Coin, Integer> coins = new HashMap<>();
		while (totalCoin > 0) {
			int randomCoin = Randoms.pickNumberInList(coinValues);
			if (randomCoin > totalCoin) {
				continue;
			}
			MapSupporter.increaseCoinCount(coins, Coin.getCoin(randomCoin), 0, 1);
			totalCoin -= randomCoin;
		}
		return coins;
	}
}
