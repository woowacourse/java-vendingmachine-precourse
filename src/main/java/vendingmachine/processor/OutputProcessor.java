package vendingmachine.processor;

import vendingmachine.Money;
import vendingmachine.coin.Coins;

public class OutputProcessor {
	private static final String PRINT_RETENTION_COINS = "자판기가 보유한 동전\n";
	private static final String PRINT_INSERT_MONEY = "투입 금액: ";

	public void printRetentionCoins(Coins coins) {
		System.out.println(PRINT_RETENTION_COINS);
		System.out.println(coins);
	}

	public void printInsertMoney(Money money) {
		System.out.println(PRINT_INSERT_MONEY);
		System.out.println(money);
		System.out.println();
	}
}
