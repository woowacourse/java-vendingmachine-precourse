package vendingmachine.view;

import java.util.HashMap;

import vendingmachine.money.Coin;

public class OutputView {
	private static final String VENDING_MACHINE_OWN_COINS = "자판기가 보유한 동전";
	private static final String MONETARY_UNIT = "원";
	private static final String COINS_FORMAT = " - ";
	private static final String COUNTING_UNIT = "개";
	private static final String REMAIN_MONEY_FORMAT = "투입 금액: ";
	private static final String CHANGE = "잔돈";

	private static void printLineBreak() {
		System.out.println();
	}

	public static void printVendingMachineOwnCoins(HashMap<Coin, Integer> coins) {
		printLineBreak();
		System.out.println(VENDING_MACHINE_OWN_COINS);
		printAllCoins(coins);
		printLineBreak();
	}

	private static void printAllCoins(HashMap<Coin, Integer> coins) {
		for (Coin coin : Coin.values()) {
			System.out.println(coin.getAmount() + MONETARY_UNIT + COINS_FORMAT + coins.get(coin) + COUNTING_UNIT);
		}
	}

	public static void printRemainMoney(int money) {
		printLineBreak();
		System.out.println(REMAIN_MONEY_FORMAT + money + MONETARY_UNIT);
	}

	public static void printChange(HashMap<Coin, Integer> coins) {
		System.out.println(CHANGE);
		for (Coin coin : coins.keySet()) {
			System.out.println(coin.getAmount() + MONETARY_UNIT + COINS_FORMAT + coins.get(coin) + COUNTING_UNIT);
		}
	}
}
