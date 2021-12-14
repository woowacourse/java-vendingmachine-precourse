package vendingmachine.utils;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class ChangeUtil {

	private static Map<Integer, Integer> changeMap = new TreeMap<>(Collections.reverseOrder());
	private static int change = 0;

	public static Map<Integer, Integer> getMinimumChangeMap(int changeAmount, Map<Integer, Integer> coinMap) {
		change = changeAmount;
		coinMap.keySet().stream().forEach(key -> addChangeMapToCoin(key, coinMap.get(key)));

		return changeMap;
	}

	private static void addChangeMapToCoin(int key, int value) {
		for (int j = 0; j < value; j++) {
			compareChangeAndCoin(key);
		}
	}

	private static void compareChangeAndCoin(int key) {
		if (change < key || change == 0) {
			return;
		}

		if (change >= key) {
			changeMap.put(key, changeMap.getOrDefault(key, 0) + 1);
			change -= key;
		}
	}
}
