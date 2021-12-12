package vendingmachine.util;

import java.util.Map;

import vendingmachine.domain.Coin;

public class MapSupporter {
	public static void increaseCoinCount(Map<Coin, Integer> coins, Coin keyCoin, final int initValue, final int value) {
		if (!coins.containsKey(keyCoin)) {
			coins.put(keyCoin, initValue);
		}
		coins.replace(keyCoin, coins.get(keyCoin), coins.get(keyCoin) + value);
	}
}
