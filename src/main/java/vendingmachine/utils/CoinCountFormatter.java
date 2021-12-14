package vendingmachine.utils;

import vendingmachine.domain.machine.coin.Coin;

public class CoinCountFormatter {

	public static String of(Coin coin, int count) {
		return String.format("%d원 - %d개", coin.getAmount(), count);
	}

}
