package vendingmachine.view;

import static vendingmachine.Constants.*;

import java.util.Map;

import vendingmachine.domain.ChangeCoins;
import vendingmachine.domain.Coin;

public class CoinView {
	public static void messagePrintCoins() {
		System.out.println(MESSAGE_PRINT_COINS);
	}

	public static void printCoins(ChangeCoins coins) {
		Map<Coin, Integer> coinData = coins.getCoins();
		for (Map.Entry<Coin, Integer> entry : coinData.entrySet()) {
			System.out.println(entry.getKey() + STRING_WON + STRING_DASH_WITH_SPACE + entry.getValue() + STRING_COUNT);
		}
	}
}
