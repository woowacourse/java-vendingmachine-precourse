package vendingmachine.view;

import static vendingmachine.resource.MessageResource.*;

import java.util.List;

import vendingmachine.domain.Changes;
import vendingmachine.domain.Coin;

public class OutputView {
	public static void printVendingmachineChanges(Changes changes) {
		List<Coin> coins = changes.orderByCoin();
		coins.forEach(coin ->
			System.out.printf(OUTPUT_CHANGES, coin.getAmount(), changes.getCoinMapValue(coin)));
	}
}
