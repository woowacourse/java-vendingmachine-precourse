package vendingmachine.view;

import java.util.Iterator;
import java.util.LinkedHashMap;

import vendingmachine.domain.Coin;
import vendingmachine.utils.Message;

public class OutputView {
	private static final String WON_FORMAT = "원 - ";
	private static final String EA_FORMAT = "개";

	public static void printHoldingCoins(LinkedHashMap<Coin, Integer> coins){
		System.out.println(Message.HOLDING_COINS_MESSAGE);
		Iterator<Coin> keys = coins.keySet().iterator();
		while (keys.hasNext()){
			Coin key = keys.next();
			int value = coins.get(key);
			System.out.println(key.getAmount() + WON_FORMAT + value + EA_FORMAT);
		}
		System.out.println();
	}
}
