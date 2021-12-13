package vendingmachine.View;

import java.util.LinkedHashMap;

import vendingmachine.Model.Coin;
import vendingmachine.Model.Money;

public class OutputView {
	public static final String PRINT_COIN_SETTING = "%s원 - %d개%n";
	public static final String PRINT_USER_MONEY_SETTING = "투입 금액: %s원%n";
	public static final String PRINT_MACHINE_COIN = "자판기가 보유한 동전";
	public static final String PRINT_CHANGE = "잔돈";

	public static void printMachineCoin(LinkedHashMap<Coin, Integer> coins) {
		System.out.println(PRINT_MACHINE_COIN);
		printCoin(coins);
	}

	public static void printUserMoney(Money money) {
		System.out.printf(PRINT_USER_MONEY_SETTING, money);
	}

	public static void printChanges(LinkedHashMap<Coin, Integer> coins) {
		System.out.println(PRINT_CHANGE);
		printCoin(coins);
	}

	public static void printCoin(LinkedHashMap<Coin, Integer> coins) {
		coins.forEach((coin, count) ->
			System.out.printf(PRINT_COIN_SETTING, coin, count)
		);
	}

	public static void printError(String error) {
		System.out.println(error);
		printBreak();
	}

	public static void printBreak() {
		System.out.println();
	}
}
