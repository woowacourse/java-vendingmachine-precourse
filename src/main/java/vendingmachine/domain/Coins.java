package vendingmachine.domain;

import java.util.Map;

public class Coins {
	private final Map<Coin, Integer> coinMap;

	public Coins(Map<Coin, Integer> coinMap) {
		this.coinMap = coinMap;
	}
}
