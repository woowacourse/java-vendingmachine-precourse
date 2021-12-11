package vendingmachine.view;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.controller.ExceptionController;
import vendingmachine.model.Product;
import vendingmachine.util.Constant;

public class InputView {
	public static ArrayList<Product> products;

	public static boolean isEmpty() {
		for (Product product : products) {
			if (product.getCount() != 0) {
				return false;
			}
		}
		return true;
	}

	public static int getMinPrice() {
		int minPrice = products.get(0).getPrice();
		for (Product product : products) {
			minPrice = Math.min(minPrice, product.getPrice());
		}
		return minPrice;
	}

	public static int askPurchase() {
		System.out.println(Constant.ASK_PRODUCT_NAME_TO_PURCHASE);
		String input = Console.readLine();
		return checkExistence(input);
	}

	private static int checkExistence(String input) {
		for (Product product : products) {
			if (product.getName().equals(input)) {
				return product.sell(product);
			}
		}
		throw new IllegalArgumentException(Constant.ERROR_DOES_NOT_EXIST);
	}

	public static int askInputAmount() {
		System.out.println(Constant.ASK_INPUT_AMOUNT);
		String input = Console.readLine();
		return ExceptionController.isValidNumber(input);
	}

	public static int askHoldingAmount() {
		System.out.println(Constant.ASK_HOLDING_AMOUNT);
		String input = Console.readLine();
		return checkHoldingAmount(input);
	}

	private static int checkHoldingAmount(String input) {
		int holdingAmount = ExceptionController.isValidNumber(input);
		ExceptionController.isMultipleOfTen(holdingAmount);
		return holdingAmount;
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
			ExceptionController.isMultipleOfTen(price);
			int count = ExceptionController.isValidNumber(info[2]);
			products.add(new Product(info[0], price, count));
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
