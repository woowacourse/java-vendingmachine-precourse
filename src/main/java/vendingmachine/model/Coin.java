package vendingmachine.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private final int amount;

	Coin(final int amount) {
		this.amount = amount;
	}

	private int getAmount() {
		return amount;
	}

	public static List<Integer> getRandomCoinList(int changes) {
		List<Integer> coinList = new ArrayList<Integer>();
		List<Integer> randomCoinList = new ArrayList<Integer>();
		Map<Integer, Integer> coinMap = new HashMap<Integer, Integer>();

		for (Coin coin : Coin.values()) {
			coinList.add(coin.getAmount());
		}

		coinMap = makeRandomCoinList(coinList, changes);

		for (Coin coin : Coin.values()) {
			randomCoinList.add(coinMap.getOrDefault(coin.amount, 0));
		}

		return randomCoinList;
	}

	private static Map<Integer, Integer> makeRandomCoinList(List<Integer> coinList, int changes) {
		int total = 0;
		Map<Integer, Integer> coinMap = new HashMap<Integer, Integer>();

		while (total < changes) {
			int randomCoin = Randoms.pickNumberInList(coinList);

			if (total + randomCoin <= changes) {
				total += randomCoin;
				coinMap.put(randomCoin, coinMap.getOrDefault(randomCoin, 0) + 1);
			}

		}

		return coinMap;
	}
	// 추가 기능 구현
}
