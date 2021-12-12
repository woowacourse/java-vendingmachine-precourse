package controller;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import utils.validator.VendingMachineChangeValidator;
import utils.validator.vendingmachineproducts.VendingMachineProductsValidator;

public class InputController {
	private static final boolean INPUT_ERROR = true;

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
				List<String> vendingMachineProducts = VendingMachineProductsValidator.checkValidVendingMachineProducts(
					Console.readLine());
				return vendingMachineProducts;

			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
	}
}
