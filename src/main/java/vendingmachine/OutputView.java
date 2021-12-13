package vendingmachine;

import java.util.Map;

public class OutputView {
	private static final String MACHINE_COIN_MESSAGE = "\n자판기가 보유한 동전";
	private static final String COIN_COUNT_MESSAGE = "%s원 - %d개\n";
	private static final String INSERTED_MONEY_MESSAGE = "\n투입 금액: %s원\n";
	private static final String CHANGES_MESSAGE = "잔돈";

	private OutputView() {
	}

	public static void printErrorMessage(String message) {
		System.out.println(message);
	}

	public static void printCoinBucket(Map<Coin, Integer> coins) {
		System.out.println(MACHINE_COIN_MESSAGE);
		printCoins(coins);
		printBlankLine();
	}

	private static void printCoins(Map<Coin, Integer> coins) {
		coins.keySet().stream()
			.sorted()
			.forEach(coin -> printCoinAndCount(coin, coins.get(coin)));
	}

	private static void printBlankLine() {
		System.out.println();
	}

	private static void printCoinAndCount(Coin coin, int count) {
		System.out.printf(COIN_COUNT_MESSAGE, coin.getAmount(), count);
	}

	public static void printInsertedMoney(Money insertedMoney) {
		System.out.printf(INSERTED_MONEY_MESSAGE, insertedMoney);
	}

	public static void printChanges(Map<Coin, Integer> changes) {
		System.out.println(CHANGES_MESSAGE);
		printExistCoins(changes);
	}

	private static void printExistCoins(Map<Coin, Integer> coins) {
		coins.keySet().stream()
			.sorted()
			.filter(Coin::isRemain)
			.forEach(coin -> printCoinAndCount(coin, coins.get(coin)));
	}
}
