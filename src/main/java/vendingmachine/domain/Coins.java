package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

	public String getHoldingCoinsAsText(){
		String holdingStatus = "";
		for (Integer amount : getReverseSortedCoinAmountKey()) {
			holdingStatus += String.format(HOLDING_COIN_AMOUNT_TEXT, amount, coins.get(amount));
		}
		return holdingStatus;
	}

	private List<Integer> getReverseSortedCoinAmountKey() {
		List<Integer> keys = new ArrayList<>(coins.keySet());
		keys.sort(Collections.reverseOrder());
		return keys;
	}

	public String getChangesAsText() {
		String status = "";
		for (Integer amount : getReverseSortedCoinAmountKey()) {
			if (coins.get(amount) <= 0) {
				continue;
			}
			status += String.format(HOLDING_COIN_AMOUNT_TEXT, amount, coins.get(amount));
		}
		return status;
	}
}
