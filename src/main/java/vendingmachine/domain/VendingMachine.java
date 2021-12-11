package vendingmachine.domain;

import java.util.Map;

public class VendingMachine {

	private Map<Coin, Integer> holdingCoin;

	public VendingMachine(Map<Coin, Integer> holdingCoin) {
		this.holdingCoin = holdingCoin;
	}

	public Map<Coin, Integer> getHoldingCoin() {
		return this.holdingCoin;
	}
}
