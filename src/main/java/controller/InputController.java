package controller;

import camp.nextstep.edu.missionutils.Console;
import utils.validator.VendingMachineChangeValidator;

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

	public static String[] inputVendingMachineProduct() {
		return Console.readLine().split(";");
	}
}
