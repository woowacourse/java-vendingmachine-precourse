package controller;

import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import utils.validator.VendingMachineChangeValidator;
import utils.validator.vendingmachineproducts.VendingMachineProductsValidator;

public class InputController {
	private static final boolean INPUT_ERROR = true;
	private static final String LEFT_BRACKET = "[";
	private static final String RIGHT_BRACKET = "]";
	private static final String EMPTY_VALUE = "";

	private InputController() {
	}

	public static int inputVendingMachineChange() {
		while (INPUT_ERROR) {
			try {
				int vendingMachineChange = VendingMachineChangeValidator.checkValidVendingMachineChange(
					Console.readLine());
				return vendingMachineChange;
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
	}

	public static List<String> inputVendingMachineProducts() {
		while (INPUT_ERROR) {
			try {
				List<String> vendingMachineProducts = tryInputVendingMachineProducts();
				return vendingMachineProducts.stream()
					.map(InputController::trimVendingMachineProduct)
					.collect(Collectors.toList());
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
	}

	private static List<String> tryInputVendingMachineProducts() {
		List<String> vendingMachineProducts = VendingMachineProductsValidator.checkValidVendingMachineProducts(
			Console.readLine());
		return VendingMachineProductsValidator.checkHasDuplicateProduct(vendingMachineProducts);
	}

	private static String trimVendingMachineProduct(String vendingMachineProduct) {
		return vendingMachineProduct.replace(LEFT_BRACKET, EMPTY_VALUE).replace(RIGHT_BRACKET, EMPTY_VALUE);
	}
}
