package vendingmachine.repository;

import java.util.HashMap;
import java.util.Map;

import vendingmachine.domain.Coin;

public class Change {

	private static final Map<Coin, Integer> change = new HashMap<>();

	public static Map<Coin, Integer> getChange() {
		return change;
	}

	public static void join(Coin coin, Integer amount) {
		change.put(coin, amount);
	}
}
