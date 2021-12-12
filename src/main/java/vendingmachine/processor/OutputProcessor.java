package vendingmachine.processor;

import vendingmachine.coin.Coins;

public class OutputProcessor {
	private static final String PRINT_RETENTION_COINS = "자판기가 보유한 동전\n";

	public void printRetentionCoins(Coins coins) {
		System.out.println(PRINT_RETENTION_COINS);
		System.out.println(coins);
	}
}
