package vendingmachine.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

import static vendingmachine.domain.Coin.*;

public class Coins {
	public final List<Integer> coinsValueList = Arrays.asList(500, 100, 50, 10);

	private Map<Coin, Integer> holdingCoins = new LinkedHashMap<>();

	public Map<Coin, Integer> initializeCoins(int holdingMoney) {
		holdingCoins.put(COIN_500, 0);
		holdingCoins.put(COIN_100, 0);
		holdingCoins.put(COIN_50, 0);
		holdingCoins.put(COIN_10, 0);
		generateCoins(holdingMoney);
		return holdingCoins;
	}

	public Map<Coin, Integer> generateCoins(int holdingMoney) {
		while (holdingMoney != 0) {
			Coin coin = pickRandomCoinValue();
			if (holdingMoney >= coin.getAmount()) {
				holdingMoney -= coin.getAmount();
				holdingCoins.put(coin, holdingCoins.get(coin) + 1);
			}
		}
		return holdingCoins;
	}

	public Coin pickRandomCoinValue() {
		int amount = Randoms.pickNumberInList(coinsValueList);
		return Coin.valueOf(amount);
	}
}
