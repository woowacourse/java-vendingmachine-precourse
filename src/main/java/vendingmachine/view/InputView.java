package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.utils.Message;

public class InputView {

	public static void printMessageToGetAmountMoneyOfVendingMachine() {
		System.out.println(Message.GET_AMOUNT_HOLDING_BY_VENDING_MACHINE.getText());
	}

	public static int inputTotalAmountMoneyOfVendingMachine() {
		return Integer.parseInt(Console.readLine());
	}

	public static void printMessageToGetInformationOfProducts() {
		System.out.println();
		System.out.println(Message.GET_INFORMATION_OF_PRODUCTS.getText());
	}

	public static String inputInformationOfProducts() {
		return Console.readLine();
	}

	public static void printMessageToGetInputMoney() {
		System.out.println();
		System.out.println(Message.GET_INPUT_MONEY.getText());
	}

	public static String inputMoneyToPutInVendingMachine() {
		return Console.readLine();
	}

	public static void printMessageToGetProductNameToBuy() {
		System.out.println(Message.GET_PRODUCT_NAME_TO_BUY.getText());
	}

	public static String inputProductNameToBuy() {
		return Console.readLine();
	}
}
