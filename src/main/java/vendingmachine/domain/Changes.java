package vendingmachine.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

public class Changes {
	private final Map<Coin, Integer> coinMap;

	public Changes(int totalAmount) {
		this.coinMap = createCoinMap(totalAmount);
	}

	public Map<Coin, Integer> createCoinMap(int totalAmount) {
		Map<Coin, Integer> copyCoinMap = initZeroCoinMap();
		List<Integer> coinList = Coin.getCoinList();

		while (totalAmount > 0) {
			int randomCoin = Randoms.pickNumberInList(coinList);
			if (totalAmount - randomCoin >= 0) {
				totalAmount -= randomCoin;
				copyCoinMap.put(Coin.getCoinType(randomCoin),
					copyCoinMap.getOrDefault(Coin.getCoinType(randomCoin), 0) + 1);
			}
		}

		return copyCoinMap;
	}

	public int getCoinMapValue(Coin coin) {
		return this.coinMap.get(coin);
	}

	private Map<Coin, Integer> initZeroCoinMap() {
		Map<Coin, Integer> zeroCoinMap = new HashMap<>();

		for (Integer coin : Coin.getCoinList()) {
			zeroCoinMap.put(Coin.getCoinType(coin), 0);
		}

		return zeroCoinMap;
	}
}
