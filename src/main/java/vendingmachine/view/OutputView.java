package vendingmachine.view;

import vendingmachine.domain.VendingMachine;
import vendingmachine.util.Constants;

public class OutputView {
	public static void printCoins() {
		System.out.println(Constants.OUTPUT_MESSAGE_COINS);
		System.out.println(VendingMachine.printCoins());
	}
}
