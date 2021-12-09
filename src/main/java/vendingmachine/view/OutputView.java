package vendingmachine.view;

import vendingmachine.util.Symbol;
import vendingmachine.util.ViewMessage;

public class OutputView {
	public static void printMachineSmallChange(String coins) {
		System.out.printf("%s",
			ViewMessage.OUTPUT_MACHINE_MONEY.getMessage() + Symbol.MEW_LINE + coins + Symbol.MEW_LINE);
	}

	public static void printPuttedMoney(int smallChange) {
		System.out.printf("%s", ViewMessage.OUTPUT_PAY_MONEY.getMessage()
			+ Symbol.COLON_SPACE + smallChange + Symbol.WON + Symbol.MEW_LINE);
	}

	public static void printRemainingSmallChange(String result) {
		System.out.printf("%s",
			ViewMessage.OUTPUT_SMALL_CHANGE.getMessage() + Symbol.MEW_LINE + result + Symbol.MEW_LINE);
	}
}
