package vendingmachine.view;

import static vendingmachine.resource.MessageResource.*;

import java.util.List;

import vendingmachine.domain.Changes;
import vendingmachine.domain.Coin;

public class OutputView {
	private OutputView() {
	}

	public static void printVendingmachineChanges(Changes changes) {
		List<Coin> coins = changes.orderByCoin();
		coins.forEach(coin ->
			System.out.printf(OUTPUT_CHANGES, coin.getAmount(), changes.getCoinMapValue(coin)));
	}

	public static void printCurrentMoney(int cuurentAmount) {
		System.out.printf(OUTPUT_INPUT_CURRENT_AMOUNT, cuurentAmount);
	}

	public static void printChanges(List<Coin> coinList) {
		for (int coin : Coin.getCoinList()) {
			sumCoinType(coinList, coin);
		}
	}

	private static void sumCoinType(List<Coin> coinList, int amount) {
		int count = 0;
		for (Coin coin : coinList) {
			if (coin.getAmount() == amount) {
				count++;
			}
		}

		if (count != 0) {
			System.out.printf(OUTPUT_CHANGES, amount, count);
		}
	}
}
