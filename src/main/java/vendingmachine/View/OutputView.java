package vendingmachine.View;

import java.util.LinkedHashMap;

public class OutputView {
	public static final String PRINT_COIN_SETTING = "%d원 - %d개%n";
	public static final String PRINT_USER_MONEY_SETTING = "투입 금액: %d원%n";
	public static final String PRINT_MACHINE_COIN = "자판기가 보유한 동전";
	public static final String PRINT_CHANGE = "잔돈";

	public static void printCoin(LinkedHashMap<Integer, Integer> coins) {
		System.out.println(PRINT_MACHINE_COIN);

		coins.forEach((coinString, count) ->
			System.out.printf(PRINT_COIN_SETTING, coinString, count)
		);
	}

	public static void printUserMoney(int money) {
		System.out.printf(PRINT_USER_MONEY_SETTING, money);
	}

	public static void printChange(LinkedHashMap<Integer, Integer> coins) {
		System.out.println(PRINT_CHANGE);
		coins.forEach((coinString, count) ->
			System.out.printf(PRINT_COIN_SETTING, coinString, count)
		);
	}

	public static void printBreak() {
		System.out.println();
	}

	public static void printError(String error) {
		System.out.println(error);
		printBreak();
	}
}
