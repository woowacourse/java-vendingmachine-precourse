package vendingmachine.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Change {

	Map<String, Integer> change;

	Change(InsertingSum insertingSum, HoldingSum holdingSum) {
		change = generateCoinGreedyByHoldingSum(insertingSum, holdingSum);
	}

	private Map<String, Integer> generateCoinGreedyByHoldingSum(InsertingSum insertingSum, HoldingSum holdingSum) {
		Map<String, Integer> coinMap = new HashMap<>();
		int accumulatedAmount = 0;

		for (Coin coin : Coin.values()) {

			while (coinMap.getOrDefault(coin.name(), 0) < holdingSum.getCoinCount(coin.name()) &&
				accumulatedAmount + coin.getAmount() <= insertingSum.get()) {
				coinMap.put(coin.name(), coinMap.getOrDefault(coin.name(), 0) + 1);
				accumulatedAmount += coin.getAmount();
			}

		}

		return coinMap;
	}

	public int getCoinCount(String coinName) {
		return change.getOrDefault(coinName, 0);
	}

	public int sum() {
		int sum = 0;

		for (Map.Entry<String, Integer> entry : change.entrySet()) {
			int coinAmount = Coin.getAmount(entry.getKey());
			int coinCount = entry.getValue();
			sum += coinAmount * coinCount;
		}

		return sum;
	}

	public Set<Map.Entry<String, Integer>> getEntrySet() {
		return change.entrySet();
	}
}
