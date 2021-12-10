package vendingmachine.view;

import java.util.Map;

import vendingmachine.domain.Change;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Money;

public class OutputView {
	private static final String PRINT_HAVING_COIN = "자판기가 보유한 동전";
	private static final String PRINT_COIN_AND_QUANTITY = "%d원 - %d개\n";
	private static final String PRINT_INPUT_MONEY = "투입 금액: %d\n";

	public static void printHavingMachineCoin() {
		System.out.println(PRINT_HAVING_COIN);

		Map<Coin, Integer> changes = Change.getChanges();

		for (Coin coin : changes.keySet()) {
			System.out.printf(PRINT_COIN_AND_QUANTITY, coin.getAmount(), changes.get(coin));
		}
	}

	public static void printInputMoney(Money money) {
		System.out.printf(PRINT_INPUT_MONEY, money.getTotal());
	}

}
