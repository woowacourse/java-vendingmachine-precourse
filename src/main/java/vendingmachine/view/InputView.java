package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.util.Constants;

public class InputView {
	public static String inputVendingMachinePrice() {
		System.out.println(Constants.INPUT_MESSAGE_VENDING_MACHINE_PRICE);
		return Console.readLine();
	}

	public static String inputProduct() {
		System.out.println(Constants.INPUT_MESSAGE_PRODUCT);
		return Console.readLine();
	}
}
