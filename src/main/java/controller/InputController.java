package controller;

import camp.nextstep.edu.missionutils.Console;
import utils.validator.VendingMachineChangeValidator;

public class InputController {

	private InputController() {
	}

	public static int inputVendingMachineChange() {
		while (true) {
			try {
				return VendingMachineChangeValidator.checkValidVendingMachineChange(Console.readLine());
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
	}
}
