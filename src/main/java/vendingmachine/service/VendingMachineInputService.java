package vendingmachine.service;

import static vendingmachine.controller.VendingMachineInputController.*;

import vendingmachine.view.ErrorMessage;

public class VendingMachineInputService {

	public static int validateInput(String stringInput) {
		try {
			int input = InputExceptionService.parseToInt(stringInput);
			InputExceptionService.checkZeroOrPositiveInt(input);
			InputExceptionService.checkModTen(input);
			return input;
		} catch (IllegalArgumentException e) {
			ErrorMessage.print(e.getMessage());
			return INVALID_INPUT;
		}

	}
}
