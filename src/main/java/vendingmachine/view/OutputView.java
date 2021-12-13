package vendingmachine.view;

import java.util.SortedMap;

import vendingmachine.domain.Coin;

public class OutputView {
	public static void printExceptionMessage(String message) {
		System.out.println(message);
	}

	public static void printMachineCoins(SortedMap<Coin, Integer> coins) {
		for (Coin key : coins.keySet()) {
			System.out.println(key.getAmount() + "원 - " + coins.get(key) + "개");
		}
		System.out.println();
	}
}
