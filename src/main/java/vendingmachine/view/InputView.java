package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static String inputVendingMachineBalance() {
		OutputView.printInputVendingMachineBalance();
		return Console.readLine();
	}

	public static String inputItems() {
		OutputView.printInputItems();
		return Console.readLine();
	}

	public static String inputUserBalance() {
		OutputView.printInputUserBalance();
		return Console.readLine();
	}

	public static String inputItemToBuy() {
		OutputView.printInputItemToBuy();
		return Console.readLine();
	}
}
