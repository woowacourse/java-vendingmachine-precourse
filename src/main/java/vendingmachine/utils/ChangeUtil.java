package vendingmachine.utils;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class ChangeUtil {

	private static Map<Integer, Integer> changeMap = new TreeMap<>(Collections.reverseOrder());

	public static Map<Integer,Integer> getMinimumChange(int change, Map<Integer,Integer> coinMap) {
		coinMap.keySet().stream().forEach(key -> addChangeMapToCoin(key,coinMap.get(key),change));

		return changeMap;
	}

	private static void addChangeMapToCoin(int key, int value, int change) {
		for (int j = 0; j < value; j++) {
			if (change >= key) {
				changeMap.put(key, changeMap.getOrDefault(key, 0) + 1);
				change -= key;
			}
			if (change < key || change <= 0) {
				break;
			}
		}
	}


}
