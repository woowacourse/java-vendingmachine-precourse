package vendingmachine;

import java.util.Map;

public class OutputView {
	private static final String MACHINE_COIN_MESSAGE = "자판기가 보유한 동전";
	private static final String COIN_COUNT_MESSAGE = "%s원 - %d개\n";

	private OutputView() {
	}

	public static void printErrorMessage(String message) {
		System.out.println(message);
	}

	public static void printCoinBucket(Map<Coin, Integer> coins) {
		System.out.println(MACHINE_COIN_MESSAGE);

		coins.keySet().stream()
			.sorted()
			.forEach(coin -> printCoinAndCount(coin, coins.get(coin)));
	}

	private static void printCoinAndCount(Coin coin, int count) {
		System.out.printf(COIN_COUNT_MESSAGE, coin.getAmount(), count);
	}
}
