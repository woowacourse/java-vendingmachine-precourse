package vendingmachine.views;

import java.util.EnumMap;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Coins;
import vendingmachine.domain.Money;

public class OutputView {
	private static final String PRINT_COINS = "자판기가 보유한 동전";
	private static final String INSERT_MONEY = "투입 금액: ";
	private static final String HYPHEN = " - ";
	private static final String COUNT = "개";

	public static void printError(String message) {
		System.out.println(message);
	}

	public static void printCoins(Coins coins) {
		System.out.println(PRINT_COINS);
		for (Coin coin : Coin.values()) {
			printCounts(coin, coins.getCoinCount(coin));
		}
	}

	public static void printMoney(Money money) {
		System.out.println(INSERT_MONEY + money.toString());
	}

	public static void printChanges(EnumMap<Coin, Integer> changes) {
		for (Coin coin : changes.keySet()) {
			printCounts(coin, changes.get(coin));
		}
	}

	private static void printCounts(Coin coin, int count) {
		System.out.println(coin + HYPHEN + count + COUNT);
	}
}
