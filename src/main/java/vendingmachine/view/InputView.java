package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.util.Constants;

public class InputView {
	public static String inputVendingMachineChange() {
		System.out.println(Constants.INPUT_MESSAGE_VENDING_MACHINE_CHANGE);
		return Console.readLine();
	}

	public static String inputProduct() {
		System.out.println(Constants.INPUT_MESSAGE_PRODUCT);
		return Console.readLine();
	}

	public static String inputUserInputAmount() {
		System.out.println(Constants.INPUT_MESSAGE_USER_INPUT_AMOUNT);
		return Console.readLine();
	}

	public static String inputProductToBuy() {
		System.out.println(Constants.INPUT_MESSAGE_PRODUCT_TO_BUY);
		return Console.readLine();
	}
}
