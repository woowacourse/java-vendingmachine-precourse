package vendingmachine.domain;

import java.util.Map;

import vendingmachine.Coin;

public class Coins {
	private final Map<Coin, Integer> coinMap;

	public Coins(Map<Coin, Integer> coinMap) {
		this.coinMap = coinMap;
	}
}
