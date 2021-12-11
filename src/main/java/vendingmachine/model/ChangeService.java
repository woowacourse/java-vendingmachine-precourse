package vendingmachine.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import vendingmachine.domain.Consumer;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.ChangeMessage;
import vendingmachine.view.ConsumerMessage;

public class ChangeService {
	public static void giveChange(VendingMachine vendingMachine, Consumer consumer) {
		ConsumerMessage.printCurrentStatusMessage(consumer);
		ChangeMessage.printInProgress();

		List<Integer> changeCount = makeChanges(vendingMachine.getBalanceMap(), consumer.getMoney());
		ChangeMessage.printChanges(changeCount);
	}

	private static List<Integer> makeChanges(Map<Integer, Integer> balanceMap, int money) {
		List<Integer> coinList = Arrays.asList(500, 100, 50, 10);
		List<Integer> changeCount = new ArrayList<>();
		for (Integer coin : coinList) {
			int possibleCoinNumber = Math.min(money / coin, balanceMap.get(coin));
			changeCount.add(possibleCoinNumber);
			money -= coin * possibleCoinNumber;
		}
		return changeCount;
	}
}
