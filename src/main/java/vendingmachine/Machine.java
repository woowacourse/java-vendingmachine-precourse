package vendingmachine;

import static vendingmachine.Coin.*;

import java.util.Map;
import java.util.TreeMap;

public enum Machine {
	MACHINE;
	private static Map<Integer, Integer> numOfCoins;

	public static void initMachine(Map<Integer, Integer> input) {
		numOfCoins = new TreeMap<Integer, Integer>() {
			{
				getCoinStream()
					.forEach(c -> put(c.getValue(), 0));
			}
		};

		// System.out.println(numOfCoins.size());
		// for(int key : numOfCoins.keySet()){
		// 	System.out.println("#" + key);
		// }

		for (int key : input.keySet()) {
			numOfCoins.put(key, input.get(key));
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		getCoinStream()
			.map(c -> c.getValue())
			.forEach(c -> sb.append(c + "원 - " + numOfCoins.get(c) + "개\n"));
		return sb.toString();
	}
}
