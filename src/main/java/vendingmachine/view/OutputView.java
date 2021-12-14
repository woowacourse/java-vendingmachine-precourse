package vendingmachine.view;

import static java.lang.System.*;
import static vendingmachine.constant.SystemMessage.*;

import java.util.List;
import java.util.Map;

import vendingmachine.constant.SystemMessage;
import vendingmachine.domain.Coin;

public class OutputView {

	public static void printMachineCoins() {
		List<Coin> coins = Coin.get();
		out.println(OUTPUT_MACHINE_MONEY);
		coins.forEach(Coin::selfDescription);
		SystemMessage.printEmptyLine();
	}

	public static void printChanges(Map<Integer, Integer> changes, int remainingMoney) {
		out.println(OUTPUT_CHANGES);
		for (Map.Entry<Integer, Integer> entry : changes.entrySet()) {
			Integer coinAmount = entry.getKey();
			Integer coinCount = entry.getValue();
			System.out.printf(SELF_DESCRIPTION_FORMAT, coinAmount, coinCount);
		}
	}
}
