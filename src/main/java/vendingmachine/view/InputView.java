package vendingmachine.view;

import static constants.ProductConstants.*;
import static constants.VendingMachineConstants.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.validator.MoneyValidator;
import vendingmachine.validator.ProductValidator;

public class InputView {
	public static List<List<String>> getProducts() {
		while (true) {
			System.out.println(PRODUCTS_INPUT_MESSAGE);
			String inputProducts = Console.readLine();
			try {
				return getProduct(inputProducts);
			} catch (IllegalArgumentException e) {
				OutputView.printError(e.getMessage());
			}
		}
	}

	public static List<List<String>> getProduct(String input) {
		String[] inputProducts = input.split(PRODUCTS_DELIMITER);
		List<List<String>> products = new ArrayList<>();
		for (String product : inputProducts) {
			products.add(ProductValidator.checkProduct(product));
		}
		return products;
	}

	public static int getVendingMachineMoney() {
		return getMoney(VENDING_MACHINE_MONEY_INPUT_MESSAGE);
	}

	public static Integer getUserMoney(Integer lowestPrice) {
		Integer userMoney = getMoney(USER_MONEY_MESSAGE);
		if (userMoney < lowestPrice) {
			throw new IllegalArgumentException(USER_MONEY_NOT_ENOUGH_ERROR);
		}
		return userMoney;
	}

	private static Integer getMoney(String Message) {
		while (true) {
			System.out.println(Message);
			String money = Console.readLine();
			try {
				MoneyValidator.checkMoney(money);
				return Integer.parseInt(money);
			} catch (IllegalArgumentException e) {
				OutputView.printError(e.getMessage());
			}
		}
	}

	public static String getProductName() {
		while (true) {
			System.out.println(BUY_PRODUCT_NAME_MESSAGE);
			String productName = Console.readLine();
			try {
				ProductValidator.checkProductName(productName);
				return productName;
			} catch (IllegalArgumentException e) {
				OutputView.printError(e.getMessage());
			}
		}
	}
}
