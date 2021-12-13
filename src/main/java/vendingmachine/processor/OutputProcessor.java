package vendingmachine.processor;

import vendingmachine.domain.coin.Coins;
import vendingmachine.domain.money.Money;

public class OutputProcessor {
	private static final String PRINT_RETENTION_COINS = "자판기가 보유한 동전";
	private static final String PRINT_INSERT_MONEY = "투입 금액: ";
	private static final String PRINT_RETURN_CHANGE = "잔돈";

	public void printRetentionCoins(Coins coins) {
		System.out.println(PRINT_RETENTION_COINS);
		System.out.println(coins);
	}

	public void printInsertMoney(Money money) {
		System.out.println(PRINT_INSERT_MONEY + money);
	}

	public void printReturnChange(Coins coins) {
		System.out.println(PRINT_RETURN_CHANGE);
		System.out.println(coins);
	}

	public void printMessage(String message) {
		System.out.println(message);
	}

	public void printLine() {
		System.out.println();
	}
}
