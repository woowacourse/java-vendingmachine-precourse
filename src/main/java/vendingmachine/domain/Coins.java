package vendingmachine.domain;

import java.util.Map;

public class Coins {
	private Map<Coin, Integer> holdingCoin;

	public Coins(Map<Coin, Integer> holdingCoin) {
		this.holdingCoin = holdingCoin;
	}

	public Map<Coin, Integer> getHoldingCoin() {
		return this.holdingCoin;
	}
}
