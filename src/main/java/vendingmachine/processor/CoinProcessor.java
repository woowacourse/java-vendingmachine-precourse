package vendingmachine.processor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.type.Coin;

public class CoinProcessor {

	private Map<Coin, Integer> coinMap = new HashMap<Coin, Integer>();

	public void generateCoinList(int money) {
		List<Integer> coins = new ArrayList<Integer>();
		while (money != 0) {
			int coinValue = getRandomCoin();
			if (coinValue > money) {
				continue;
			}
			coins.add(coinValue);
			money -= coinValue;
		}
		initCoinMap(coins);
	}

	private void initCoinMap(List<Integer> coins) {
		for (Coin coin : Coin.getCoinList()) {
			coinMap.put(coin, Collections.frequency(coins, coin.getAmount()));
		}
	}

	private int getRandomCoin() {
		return Randoms.pickNumberInList(Coin.getCoinValues());
	}
}
