package vendingmachine.view;

import java.util.Map;

import vendingmachine.domain.Coin;

public class CoinView {
	private static final String COIN_LIST_FORMAT = "%d원 - %d개";
	private static final String CHANGE_MESSAGE = "잔돈";

	public static void printCoinMap(Map<Coin, Integer> coinMap) {
		for (Coin coin : Coin.values()) {
			if (coinMap.containsKey(coin)) {
				System.out.printf((COIN_LIST_FORMAT) + "%n", coin.getAmount(), coinMap.get(coin));
			}
		}
		System.out.println();
	}

	public static void printChange() {
		System.out.println(CHANGE_MESSAGE);
	}
}
