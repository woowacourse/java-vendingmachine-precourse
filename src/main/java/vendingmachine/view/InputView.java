package vendingmachine.view;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.controller.NumberController;
import vendingmachine.controller.FormatController;
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
		return NumberController.isValidNumber(input);
	}

	public static int askHoldingAmount() {
		System.out.println(Constant.ASK_HOLDING_AMOUNT);
		String input = Console.readLine();
		return checkHoldingAmount(input);
	}

	private static int checkHoldingAmount(String input) {
		int holdingAmount = NumberController.isValidNumber(input);
		NumberController.isMultipleOfTen(holdingAmount);
		return holdingAmount;
	}

	public static void askProductInfo() {
		System.out.println(Constant.ASK_PRODUCT_INFO);
		String[] products = FormatController.splitProducts(Console.readLine());
		checkProducts(products);
		String[][] information = checkInfoFormat(products);
		inputProduct(information);
	}

	private static void checkProducts(String[] products) {
		for (int i = 0; i < products.length; i++) {
			FormatController.isInfoFormatValidate(products[i]);
			products[i] = FormatController.removeParentheses(products[i]);
		}
	}

	private static String[][] checkInfoFormat(String[] products) {
		String[][] information = new String[products.length][3];
		for (int i = 0; i < products.length; i++) {
			information[i] = FormatController.splitInfo(products[i]);
			FormatController.isNumberOfInfo3(information[i]);
		}
		return information;
	}

	private static void inputProduct(String[][] information) {
		products = new ArrayList<>();
		for (String[] info : information) {
			Product product = generateProduct(info);
			addProduct(products, product);
		}
	}

	private static void addProduct(ArrayList<Product> products, Product product) {
		for (Product p : products) {
			FormatController.isSameName(p.getName(), product.getName());
		}
		products.add(product);
	}

	private static Product generateProduct(String[] info) {
		String name = FormatController.containsNull(info[0]);
		int price = NumberController.isValidNumber(info[1]);
		NumberController.isMultipleOfTen(price);
		int count = NumberController.isValidNumber(info[2]);
		return new Product(name, price, count);
	}
}
