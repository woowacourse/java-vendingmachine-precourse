package vendingmachine.view;

import java.util.Map;

import vendingmachine.billing.Coin;
import vendingmachine.billing.Money;

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

	public static void printVendingMachineOwnCoins(Map<Coin, Integer> coins) {
		printLineBreak();
		System.out.println(VENDING_MACHINE_OWN_COINS);
		printAllCoins(coins);
		printLineBreak();
	}

	private static void printAllCoins(Map<Coin, Integer> coins) {
		coins.forEach((key, value) -> System.out.println(
			key.toString() + MONETARY_UNIT + COINS_FORMAT + value + COUNTING_UNIT));
	}

	public static void printRemainMoney(Money money) {
		printLineBreak();
		System.out.println(REMAIN_MONEY_FORMAT + money.toString() + MONETARY_UNIT);
	}

	public static void printChange(Map<Coin, Integer> changeCoins) {
		System.out.println(CHANGE);
		printAllCoins(changeCoins);
	}
}
