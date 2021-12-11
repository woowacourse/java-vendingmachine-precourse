package vendingmachine.view;

import static vendingmachine.utils.validator.ProductInfoValidator.*;


import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.utils.Message;
import vendingmachine.utils.validator.InputMoneyValidator;

public class InputView {

	private static final String INPUT_SPLIT_DELIMITER = ";";

	public static int inputTotalAmountMoneyOfVendingMachine() {
		System.out.println(Message.GET_AMOUNT_HOLDING_BY_VENDING_MACHINE.getText());
		while (true) {
			String inputMoney = Console.readLine();
			if (InputMoneyValidator.checkIsValidInputMoney(inputMoney)) {
				return Integer.parseInt(inputMoney);
			}
		}
	}

	public static List<String> inputInformationOfProducts() {
		System.out.println();
		while (true) {
			System.out.println(Message.GET_INFORMATION_OF_PRODUCTS.getText());
			List<String> productInfoList = Arrays.asList(Console.readLine().split(INPUT_SPLIT_DELIMITER));
			if (checkIsValidProductInfoList(productInfoList)) {
				return productInfoList;
			}

		}
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
