package vendingmachine.view;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.utils.message.SystemMessage;

public class InputView {

	private static final String INPUT_SPLIT_DELIMITER = ";";

	public static String inputTotalAmountOfVendingMachine() {
		System.out.println(SystemMessage.GET_TOTAL_AMOUNT_OF_VENDING_MACHINE.getText());
		return Console.readLine();
	}

	public static List<String> inputInformationOfProducts() {
		System.out.println();
		System.out.println(SystemMessage.GET_INFORMATION_OF_PRODUCTS.getText());
		return Arrays.asList(Console.readLine().split(INPUT_SPLIT_DELIMITER));
	}

	public static String insertMoneyIntoVendingMachine() {
		System.out.println();
		System.out.println(SystemMessage.GET_INSERT_MONEY.getText());
		return Console.readLine();
	}

	public static String inputProductNameToBuy() {
		System.out.println(SystemMessage.GET_PRODUCT_NAME_TO_BUY.getText());
		return Console.readLine();
	}
}
