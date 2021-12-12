package vendingmachine.domain;

import java.util.Collections;
import java.util.Map;

public class Coins {
	public static final String HOLDING_COIN_AMOUNT_TEXT = "%s원 - %s개%n";
	private final Map<Integer, Integer> coins;

	public Coins(Map<Integer, Integer> coins) {
		this.coins = coins;
	}

	public Map<Integer, Integer> findAll() {
		return Collections.unmodifiableMap(coins);
	}

	public String getHoldingCoinsAsText() {
		String holdingStatus = "";
		for (Integer amount : coins.keySet()) {
			holdingStatus += String.format(HOLDING_COIN_AMOUNT_TEXT, amount, coins.get(amount));
		}
		return holdingStatus;
	}

	public String getChangesAsText() {
		String status = "";
		for (Integer amount : coins.keySet()) {
			if (coins.get(amount) <= 0) {
				continue;
			}
			status += String.format(HOLDING_COIN_AMOUNT_TEXT, amount, coins.get(amount));
		}
		return status;
	}
}
