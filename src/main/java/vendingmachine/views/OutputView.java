package vendingmachine.views;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Coins;

public class OutputView {
	private static final String PRINT_COINS = "자판기가 보유한 동전";
	private static final String HYPHEN = " - ";
	private static final String COUNT = "개";

	public static void printError(String message) {
		System.out.println(message);
	}

	public static void printCoins(Coins coins) {
		System.out.println(PRINT_COINS);
		for (Coin coin : Coin.values()) {
			System.out.println(coin.toString() + HYPHEN + coins.getCoinCount(coin) + COUNT);
		}
	}
}
