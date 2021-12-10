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
		System.out.println(Message.GET_INFORMATION_OF_PRODUCTS.getText());
	}

	public static String inputInformationOfProducts() {
		return Console.readLine();
	}
}
