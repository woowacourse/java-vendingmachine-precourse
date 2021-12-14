package vendingmachine;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class ChangeCalculation {
	private static final Map<Coin, Integer> change = new LinkedHashMap<>();
	private static int changeAmountRemaining;

	public static Map<Coin, Integer> calculateChange(Map<Coin, Integer> vendingMachineCoin, int insertAmount) {
		Arrays.stream(Coin.values()).forEach(coin -> change.put(coin, 0));
		changeAmountRemaining = insertAmount;

		while (true) {
			Coin changeCoin = findMaxPriceCoinLessThanInsertAmount(vendingMachineCoin);
			if (changeCoin == null) {
				break;
			}
			addCoin(vendingMachineCoin, changeCoin);
		}
		return change;
	}

	private static void addCoin(Map<Coin, Integer> vendingMachineCoin, Coin changeCoin) {
		change.put(changeCoin, change.get(changeCoin) + 1);
		vendingMachineCoin.put(changeCoin, vendingMachineCoin.get(changeCoin) - 1);
		changeAmountRemaining -= changeCoin.getAmount();
	}

	private static Coin findMaxPriceCoinLessThanInsertAmount(Map<Coin, Integer> vendingMachineCoin) {
		return vendingMachineCoin.keySet().stream()
			.filter(coin -> vendingMachineCoin.get(coin) > 0)
			.filter(coin -> coin.getAmount() <= changeAmountRemaining)
			.findFirst().orElse(null);
	}
}
