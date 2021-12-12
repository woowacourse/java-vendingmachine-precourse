package vendingmachine.domain;

import java.util.Map;

public class CoinCounter {
	private Map<Integer, Integer> coinCounter;

	public CoinCounter(Map<Integer, Integer> coinCounter) {
		this.coinCounter = coinCounter;
	}
}
