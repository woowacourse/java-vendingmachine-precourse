package vendingmachine.domain;

import java.util.HashMap;
import java.util.Map;

public class Change {

	private static final Map<Coin, Integer> change = new HashMap<>();

	public static Map<Coin, Integer> getChange() {
		return change;
	}

	public static void setChange(Coin coin, Integer amount) {
		change.put(coin, amount);
	}
}
