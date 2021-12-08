package vendingmachine.view;

import static constants.VendingMachineConstants.*;

public class OutputView {
	public static void printError(String message) {
		System.out.println(ERROR_PREFIX + message);
	}
}
