package vendingmachine.view;

import java.util.Map;

import vendingmachine.domain.Change;
import vendingmachine.domain.Coin;

public class OutputView {
	private static final String PRINT_HAVING_COIN = "자판기가 보유한 동전";
	private static final String PRINT_COIN_AND_QUANTITY = "%d원 - %d개\n";

	public static void printHavingMoney() {
		System.out.println(PRINT_HAVING_COIN);

		Map<Coin, Integer> changes = Change.getChanges();

		for (Coin coin : changes.keySet()) {
			System.out.printf(PRINT_COIN_AND_QUANTITY, coin.getAmount(), changes.get(coin));
		}

	}

}
