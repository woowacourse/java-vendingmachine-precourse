package vendingmachine.view;

import java.util.Map;

import vendingmachine.domain.Change;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Money;

public class OutputView {
	private static final String PRINT_HAVING_COIN = "자판기가 보유한 동전";
	private static final String PRINT_COIN_AND_QUANTITY = "%d원 - %d개\n";
	private static final String PRINT_INPUT_MONEY = "투입 금액: %d원\n";
	private static final String PRINT_EXTRA_MONEY = "잔돈";
	private static final int NONE = 0;

	public static void printHavingMachineCoin(Change change) {
		System.out.println(PRINT_HAVING_COIN);
		Map<Coin, Integer> changes = change.getChanges();

		for (Coin coin : changes.keySet()) {
			System.out.printf(PRINT_COIN_AND_QUANTITY, coin.getAmount(), changes.get(coin));
		}
	}

	public static void printInputMoney(Money money) {
		System.out.printf(PRINT_INPUT_MONEY, money.getTotal());
	}

	public static void printExtraMoneyAndChange(Change change) {
		Map<Coin, Integer> changes = change.getChanges();

		System.out.println(PRINT_EXTRA_MONEY);
		for (Coin coin : changes.keySet()) {
			if (changes.get(coin).equals(NONE)) {
				continue;
			}
			System.out.printf(PRINT_COIN_AND_QUANTITY, coin.getAmount(), changes.get(coin));
		}
	}
}
