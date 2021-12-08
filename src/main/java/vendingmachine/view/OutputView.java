package vendingmachine.view;

import vendingmachine.util.Symbol;
import vendingmachine.util.ViewMessage;

public class OutputView {
	public static void printMachineSmallChange(String coins) {
		System.out.printf("%s", ViewMessage.OUTPUT_MACHINE_MONEY.getMessage() + Symbol.MEW_LINE + coins);
	}
}
