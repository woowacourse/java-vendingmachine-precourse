package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.controller.ExceptionController;
import vendingmachine.util.Constant;

public class InputView {
	public static void askHoldingAmount() {
		System.out.println(Constant.ASK_HOLDING_AMOUNT);
		String input = Console.readLine();
		checkHoldingAmount(input);
	}

	private static void checkHoldingAmount(String input) {
		ExceptionController.isInteger(input);
		int holdingAmount = Integer.parseInt(input);
		ExceptionController.isPositive(holdingAmount);
		ExceptionController.isMultipleOfTen(holdingAmount);
	}

	public static void askProductInfo() {
		System.out.println(Constant.ASK_PRODUCT_INFO);
		String[] products = splitProducts(Console.readLine());
		checkProducts(products);
		String[][] information = checkInfoFormat(products);
	}


	private static void checkProducts(String[] products) {
		for (int i = 0; i < products.length; i++) {
			ExceptionController.isInfoFormatValidate(products[i]);
			products[i] = removeParentheses(products[i]);
		}
	}

	private static String[][] checkInfoFormat(String[] products) {
		String[][] information = new String[products.length][3];
		for (int i = 0; i < products.length; i++) {
			information[i] = splitInfo(products[i]);
			ExceptionController.isNumberOfInfo3(information[i]);
		}
		return information;
	}

	private static String[] splitProducts(String input) {
		return input.split(";");
	}

	private static String removeParentheses(String input) {
		return input.substring(1, input.length() - 1);
	}

	private static String[] splitInfo(String input) {
		return input.split(",");
	}
}
