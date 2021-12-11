package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.utils.Message;

public class InputView {

	public static int inputTotalAmountMoneyOfVendingMachine() {
		System.out.println(Message.GET_AMOUNT_HOLDING_BY_VENDING_MACHINE.getText());
		return Integer.parseInt(Console.readLine());
	}

	public static String inputInformationOfProducts() {
		System.out.println();
		System.out.println(Message.GET_INFORMATION_OF_PRODUCTS.getText());
		return Console.readLine();
	}

	public static String inputMoneyToPutInVendingMachine() {
		System.out.println();
		System.out.println(Message.GET_INPUT_MONEY.getText());
		return Console.readLine();
	}

	public static String inputProductNameToBuy() {
		System.out.println(Message.GET_PRODUCT_NAME_TO_BUY.getText());
		return Console.readLine();
	}
}
