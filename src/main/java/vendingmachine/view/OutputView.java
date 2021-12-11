package vendingmachine.view;

import java.util.Map;

import vendingmachine.domain.Coin;
import vendingmachine.domain.VendingMachine;

public class OutputView {
	private static final String COIN_ACQUIRED = "자판기가 보유한 동전";
	private static final String COIN_LIST = "%s원 - %d개%n";
	private static final String BALANCE_MESSAGE = "투입 금액: %d원%n";
	private static final int COIN_VALUE_INDEX = 5;

	public static void showError(String error) {
		System.out.println(error);
		System.out.println();
	}

	public static void showCoins(VendingMachine vendingMachine) {
		System.out.println();
		System.out.println(COIN_ACQUIRED);
		for (Map.Entry<Coin, Integer> coin : vendingMachine.getCoins().entrySet()) {
			System.out.printf(COIN_LIST, coin.getKey().name().substring(COIN_VALUE_INDEX), coin.getValue());
		}
	}

	public static void showBalance(VendingMachine vendingMachine) {
		System.out.println();
		System.out.printf(BALANCE_MESSAGE, vendingMachine.getBalance());
	}
}
