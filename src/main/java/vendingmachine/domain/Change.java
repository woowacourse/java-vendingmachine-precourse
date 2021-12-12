package vendingmachine.domain;

import java.util.HashMap;
import java.util.Map;

import vendingmachine.enums.Coin;

public class Change {
	private final Map<Coin, Quantity> change;

	public Change() {
		change = new HashMap<>();
	}

	public void put(Coin coin, Quantity quantity) {
		change.put(coin, quantity);
	}

	public Quantity get(Coin coin) {
		return change.get(coin);
	}
}
