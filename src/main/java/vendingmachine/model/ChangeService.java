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
		ChangeMessage.printInProgress();

		Map<Coin, Integer> changeMap = makeChanges(vendingMachine.getBalanceMap(), consumer.getMoney(),
			new LinkedHashMap<>());
		ChangeMessage.printChanges(changeMap);
	}

	private static Map<Coin, Integer> makeChanges(Map<Coin, Integer> balanceMap, int money,
		Map<Coin, Integer> changeMap) {
		for (Map.Entry<Coin, Integer> entry : balanceMap.entrySet()) {
			int possibleCoinNumber = Math.min(money / entry.getKey().getAmount(), entry.getValue());
			changeMap.put(entry.getKey(), possibleCoinNumber);
			money -= entry.getKey().getAmount() * possibleCoinNumber;
		}
		return changeMap;
	}
}
