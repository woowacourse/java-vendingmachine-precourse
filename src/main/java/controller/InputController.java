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
				return VendingMachineChangeValidator.checkValidVendingMachineChange(Console.readLine());
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
	}
}
