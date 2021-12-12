package vendingmachine.util;

import java.util.Map;

import vendingmachine.domain.Coin;

public class MapSupporter {
	public static void increaseValue(Map<Coin, Integer> map, Coin keyCoin, final int initValue, final int value) {
		if (!map.containsKey(keyCoin)) {
			map.put(keyCoin, initValue);
		}
		map.replace(keyCoin, map.get(keyCoin), map.get(keyCoin) + value);
	}
}
