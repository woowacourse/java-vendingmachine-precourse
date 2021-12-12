package vendingmachine.view;

import static vendingmachine.utils.validator.MoneyValidator.*;
import static vendingmachine.utils.validator.ProductInfoValidator.*;


import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.utils.SystemMessage;

public class InputView {

	private static final String INPUT_SPLIT_DELIMITER = ";";

	public static int inputTotalAmountOfVendingMachine() {
		System.out.println(SystemMessage.GET_TOTAL_AMOUNT_OF_VENDING_MACHINE.getText());
		while (true) {
			String totalAmount = Console.readLine();
			if (checkIsValidTotalAmount(totalAmount)) {
				return Integer.parseInt(totalAmount);
			}
		}
	}

	public static List<String> inputInformationOfProducts() {
		System.out.println();
		while (true) {
			System.out.println(SystemMessage.GET_INFORMATION_OF_PRODUCTS.getText());
			List<String> productInfoList = Arrays.asList(Console.readLine().split(INPUT_SPLIT_DELIMITER));
			if (checkIsValidProductInfoList(productInfoList)) {
				return productInfoList;
			}

		}
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

	public static String inputProductNameToBuy() {
		System.out.println(SystemMessage.GET_PRODUCT_NAME_TO_BUY.getText());
		return Console.readLine();
	}
}
