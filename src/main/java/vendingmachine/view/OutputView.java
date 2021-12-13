package vendingmachine.view;

import java.util.SortedMap;

import vendingmachine.domain.Coin;

public class OutputView {
	public static void printExceptionMessage(String message) {
		System.out.println(message);
	}

	public static void printHeadFirst() {
		System.out.println();
		System.out.println("자판기가 보유한 동전");
	}

	public static void printHeadLast() {
		System.out.println("잔돈");
	}

	public static void printMachineCoins(SortedMap<Coin, Integer> coins) {
		for (Coin key : coins.keySet()) {
			System.out.println(key.getAmount() + "원 - " + coins.get(key) + "개");
		}
	}

	public static void printInputCoins(Integer amount) {
		System.out.println();
		System.out.println("투입 금액: " + amount + "원");
	}
}
