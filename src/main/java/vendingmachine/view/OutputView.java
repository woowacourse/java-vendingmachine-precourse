package vendingmachine.view;

import vendingmachine.domain.VendingMachine;
import vendingmachine.util.Constants;

public class OutputView {
	public static void printCoins(VendingMachine vendingMachine) {
		System.out.println(Constants.OUTPUT_MESSAGE_COINS);
		System.out.println(vendingMachine.coinsToString());
	}

	public static void printUserInputAmount(String userInputAmount) {
		System.out.print(Constants.OUTPUT_MESSAGE_USER_INPUT_AMOUNT);
		System.out.println(userInputAmount);
	}

	public static void printReturnedCoins(String returnedCoins) {
		System.out.println(Constants.OUTPUT_MESSAGE_RETURNED_COINS);
		System.out.println(returnedCoins);
	}
}
