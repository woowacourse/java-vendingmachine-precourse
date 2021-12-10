package vendingmachine.view;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.controller.ExceptionController;
import vendingmachine.model.Products;
import vendingmachine.util.Constant;

public class InputView {
	public static ArrayList<Products> products;

	public static void askHoldingAmount() {
		System.out.println(Constant.ASK_HOLDING_AMOUNT);
		String input = Console.readLine();
		checkHoldingAmount(input);
	}

	private static void checkHoldingAmount(String input) {
		int holdingAmount = ExceptionController.isValidNumber(input);
		ExceptionController.isMultipleOfTen(holdingAmount);
	}

	public static void askProductInfo() {
		System.out.println(Constant.ASK_PRODUCT_INFO);
		String[] products = splitProducts(Console.readLine());
		checkProducts(products);
		String[][] information = checkInfoFormat(products);
		inputProduct(information);
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

	private static void inputProduct(String[][] information) {
		products = new ArrayList<>();
		for (String[] info : information) {
			int price = ExceptionController.isValidNumber(info[1]);
			int count = ExceptionController.isValidNumber(info[2]);
			products.add(new Products(info[0], price, count));
		}
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
