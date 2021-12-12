package vendingmachine.model;

import java.util.LinkedHashMap;
import java.util.Map;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Consumer;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.ChangeMessage;
import vendingmachine.view.ConsumerMessage;

public class ChangeService {
	public static void giveChange(VendingMachine vendingMachine, Consumer consumer) {
		ConsumerMessage.printCurrentStatusMessage(consumer);
		ChangeMessage.printChangeStatement();

		Map<Coin, Integer> changeMap = makeChanges(vendingMachine.getBalanceMap(), consumer.getMoney(),
			new LinkedHashMap<>());
		ChangeMessage.printChanges(changeMap);
	}

	private static Map<Coin, Integer> makeChanges(Map<Coin, Integer> balanceMap, int money,
		Map<Coin, Integer> changeMap) {
		for (Map.Entry<Coin, Integer> entry : balanceMap.entrySet()) {
			int optimalCoinCount = getOptimalCoinCount(money, entry);
			changeMap.put(entry.getKey(), optimalCoinCount);
			money -= entry.getKey().getAmount() * optimalCoinCount;
		}
		return changeMap;
	}

	private static int getOptimalCoinCount(int money, Map.Entry<Coin, Integer> entry) {
		int requiringCount = money / entry.getKey().getAmount();
		int possessingCount = entry.getValue();
		return Math.min(requiringCount, possessingCount);
	}
}
