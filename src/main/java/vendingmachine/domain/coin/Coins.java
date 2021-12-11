package vendingmachine.domain.coin;

import java.util.Map;

public class Coins {
	private final Map<Coin, Integer> coinMap;

	public Coins(Map<Coin, Integer> coinMap) {
		this.coinMap = coinMap;
	}

	public Map<Coin, Integer> getCoins() {
		return coinMap;
	}
}
