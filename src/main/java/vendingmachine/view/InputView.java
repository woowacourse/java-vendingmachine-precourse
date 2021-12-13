package vendingmachine.view;

import static vendingmachine.utils.validator.MoneyValidator.*;
import static vendingmachine.utils.validator.ProductValidator.*;


import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.VendingMachine;
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

	public static String inputMoneyToPutInVendingMachine() {
		System.out.println();
		System.out.println(SystemMessage.GET_INPUT_MONEY.getText());
		while (true) {
			String inputMoney = Console.readLine();
			if (checkIsValidInputMoney(inputMoney)) {
				return inputMoney;
			}
		}
	}

	public static String inputProductNameToBuy(VendingMachine vendingMachine) {
		System.out.println(SystemMessage.GET_PRODUCT_NAME_TO_BUY.getText());
		while (true) {
			String productName = Console.readLine();
			if (checkIsValidToBuyProduct(vendingMachine, productName)) {
				return productName;
			}
		}
	}
}
