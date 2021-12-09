package vendingmachine.view;

import static constants.ProductConstants.*;
import static constants.VendingMachineConstants.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.validator.NumberValidator;
import vendingmachine.validator.ProductValidator;

public class InputView {
	public static int getVendingMachineMoney() {
		while (true) {
			System.out.println(VENDING_MACHINE_MONEY_INPUT_MESSAGE);
			String inputMachineMoney = Console.readLine();
			try {
				NumberValidator.checkNumber(inputMachineMoney);
				return Integer.parseInt(inputMachineMoney);
			} catch (IllegalArgumentException e) {
				OutputView.printError(e.getMessage());
			}
		}
	}

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
}
