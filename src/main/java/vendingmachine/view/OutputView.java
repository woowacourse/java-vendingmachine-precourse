package vendingmachine.view;

import java.util.Collections;
import java.util.List;

import vendingmachine.Coin;

public class OutputView {
	private static final String VENDING_MACHINE_OWN_COINS = "자판기가 보유한 동전";
	private static final String MONETARY_UNIT = "원";
	private static final String COINS_FORMAT = " - ";
	private static final String COUNTING_UNIT = "개";

	private static void printLineBreak() {
		System.out.println();
	}

	public static void printVendingMachineOwnCoins(List<Integer> coins) {
		printLineBreak();
		System.out.println(VENDING_MACHINE_OWN_COINS);
		countCoins(coins);
	}

	private static void countCoins(List<Integer> coins) {
		for (Coin coin : Coin.values()) {
			int money = coin.getAmount();
			System.out.println(
				money + MONETARY_UNIT + COINS_FORMAT + Collections.frequency(coins, money) + COUNTING_UNIT);
		}
	}
}
